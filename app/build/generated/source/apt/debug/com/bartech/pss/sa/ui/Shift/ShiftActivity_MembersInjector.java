package com.bartech.pss.sa.ui.Shift;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ShiftActivity_MembersInjector implements MembersInjector<ShiftActivity> {
  private final Provider<ShiftMvpPresenter<ShiftMvpView>> mPresenterProvider;

  public ShiftActivity_MembersInjector(
      Provider<ShiftMvpPresenter<ShiftMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ShiftActivity> create(
      Provider<ShiftMvpPresenter<ShiftMvpView>> mPresenterProvider) {
    return new ShiftActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ShiftActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      ShiftActivity instance, Provider<ShiftMvpPresenter<ShiftMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
