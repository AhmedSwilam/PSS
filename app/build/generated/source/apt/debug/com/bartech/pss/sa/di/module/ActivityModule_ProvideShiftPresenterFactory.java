package com.bartech.pss.sa.di.module;

import com.bartech.pss.sa.ui.Shift.ShiftMvpPresenter;
import com.bartech.pss.sa.ui.Shift.ShiftMvpView;
import com.bartech.pss.sa.ui.Shift.ShiftPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideShiftPresenterFactory
    implements Factory<ShiftMvpPresenter<ShiftMvpView>> {
  private final ActivityModule module;

  private final Provider<ShiftPresenter<ShiftMvpView>> presenterProvider;

  public ActivityModule_ProvideShiftPresenterFactory(
      ActivityModule module, Provider<ShiftPresenter<ShiftMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public ShiftMvpPresenter<ShiftMvpView> get() {
    return Preconditions.checkNotNull(
        module.provideShiftPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ShiftMvpPresenter<ShiftMvpView>> create(
      ActivityModule module, Provider<ShiftPresenter<ShiftMvpView>> presenterProvider) {
    return new ActivityModule_ProvideShiftPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideShiftPresenter(ShiftPresenter)}. */
  public static ShiftMvpPresenter<ShiftMvpView> proxyProvideShiftPresenter(
      ActivityModule instance, ShiftPresenter<ShiftMvpView> presenter) {
    return instance.provideShiftPresenter(presenter);
  }
}
