package com.bartech.pss.sa.ui.Shift;

import com.bartech.pss.sa.data.DataManager;
import com.bartech.pss.sa.utils.rx.SchedulerProvider;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ShiftPresenter_Factory<V extends ShiftMvpView>
    implements Factory<ShiftPresenter<V>> {
  private final MembersInjector<ShiftPresenter<V>> shiftPresenterMembersInjector;

  private final Provider<DataManager> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public ShiftPresenter_Factory(
      MembersInjector<ShiftPresenter<V>> shiftPresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    assert shiftPresenterMembersInjector != null;
    this.shiftPresenterMembersInjector = shiftPresenterMembersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert compositeDisposableProvider != null;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public ShiftPresenter<V> get() {
    return MembersInjectors.injectMembers(
        shiftPresenterMembersInjector,
        new ShiftPresenter<V>(
            dataManagerProvider.get(), schedulerProvider.get(), compositeDisposableProvider.get()));
  }

  public static <V extends ShiftMvpView> Factory<ShiftPresenter<V>> create(
      MembersInjector<ShiftPresenter<V>> shiftPresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new ShiftPresenter_Factory<V>(
        shiftPresenterMembersInjector,
        dataManagerProvider,
        schedulerProvider,
        compositeDisposableProvider);
  }
}
