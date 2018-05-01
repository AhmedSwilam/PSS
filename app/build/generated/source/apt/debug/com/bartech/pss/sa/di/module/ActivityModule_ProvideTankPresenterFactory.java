package com.bartech.pss.sa.di.module;

import com.bartech.pss.sa.ui.tank.TankMvpPresenter;
import com.bartech.pss.sa.ui.tank.TankMvpView;
import com.bartech.pss.sa.ui.tank.TankPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideTankPresenterFactory
    implements Factory<TankMvpPresenter<TankMvpView>> {
  private final ActivityModule module;

  private final Provider<TankPresenter<TankMvpView>> presenterProvider;

  public ActivityModule_ProvideTankPresenterFactory(
      ActivityModule module, Provider<TankPresenter<TankMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public TankMvpPresenter<TankMvpView> get() {
    return Preconditions.checkNotNull(
        module.provideTankPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TankMvpPresenter<TankMvpView>> create(
      ActivityModule module, Provider<TankPresenter<TankMvpView>> presenterProvider) {
    return new ActivityModule_ProvideTankPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideTankPresenter(TankPresenter)}. */
  public static TankMvpPresenter<TankMvpView> proxyProvideTankPresenter(
      ActivityModule instance, TankPresenter<TankMvpView> presenter) {
    return instance.provideTankPresenter(presenter);
  }
}
