package com.cyrilmarten.conf.conpro17mobile.conferences.other.di.modules;

import com.cyrilmarten.conf.conpro17mobile.BuildConfig;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup.DataRepositoryImpl;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DataRepository;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DataRestRepositoryImpl;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.Model;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.ModelImpl;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.api.ApiInterface;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.authentication.OkHttpAuthenticator;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ModelModule {
    private final String baseUrl;

    public ModelModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG_MODE) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        builder.authenticator(new OkHttpAuthenticator());

        return builder.build();
    }

    @Provides
	@Inject
    @Singleton
    public Retrofit provideRestAdapter(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder.build();
    }

	@Provides
	@Inject
	@Singleton
	public ApiInterface provideApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
	}

	@Provides
	@Inject
	@Singleton
	public DataRestRepositoryImpl provideDataRestRepository(ApiInterface apiInterface) {
		return new DataRestRepositoryImpl(apiInterface);
	}

	@Provides
	@Inject
	@Singleton
	public DataRepository provideDataRepository(DataRestRepositoryImpl dataRestRepository) {
		return new DataRepositoryImpl(dataRestRepository);
	}

	@Provides
	@Inject
	@Singleton
	public Model provideModel(DataRepository dataRepository) {
		return new ModelImpl(dataRepository);
	}
}

