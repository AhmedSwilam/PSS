package com.bartech.pss.sa.ui.tank;

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
public final class TankPresenter_Factory<V extends TankMvpView>
    implements Factory<TankPresenter<V>> {
  private final MembersInjector<TankPresenter<V>> tankPresenterMembersInjector;

  private final Provider<DataManager> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public TankPresenter_Factory(
      MembersInjector<TankPresenter<V>> tankPresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    assert tankPresenterMembersInjector != null;
    this.tankPresenterMembersInjector = tankPresenterMembersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert compositeDisposableProvider != null;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public TankPresenter<V> get() {
    return MembersInjectors.injectMembers(
        tankPresenterMembersInjector,
        new TankPresenter<V>(
            dataManagerProvider.get(), schedulerProvider.get(), compositeDisposableProvider.get()));
  }

  public static <V extends TankMvpView> Factory<TankPresenter<V>> create(
      MembersInjector<TankPresenter<V>> tankPresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new TankPresenter_Factory<V>(
        tankPresenterMembersInjector,
        dataManagerProvider,
        schedulerProvider,
        compositeDisposableProvider);
  }
}
