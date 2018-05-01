package com.bartech.pss.sa.ui.tank;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TankActivity_MembersInjector implements MembersInjector<TankActivity> {
  private final Provider<TankMvpPresenter<TankMvpView>> mPresenterProvider;

  public TankActivity_MembersInjector(Provider<TankMvpPresenter<TankMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<TankActivity> create(
      Provider<TankMvpPresenter<TankMvpView>> mPresenterProvider) {
    return new TankActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(TankActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      TankActivity instance, Provider<TankMvpPresenter<TankMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
