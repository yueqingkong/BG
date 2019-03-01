package block.guess.betting.presenter;

import block.guess.betting.contract.GiveFriendContract;

public class GiveFriendPresenter implements GiveFriendContract.Presenter{

    private GiveFriendContract.BView baseView;
    public GiveFriendPresenter(GiveFriendContract.BView view){
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
    }
}
