package webb8.wathub.hub.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import webb8.wathub.hub.Action;
import webb8.wathub.hub.NavItem;
import webb8.wathub.hub.HubActivity;

/**
 * Created by mismayil on 23/02/16.
 */
public class HubFragment extends Fragment {

    protected static final String ARG_ACTION_NUMBER = "ACTION_NUMBER";
    protected static Activity mHubActivity;

    public HubFragment() {}

    public static HubFragment newInstance(int action) {
        HubFragment fragment = null;

        if (action == NavItem.PROFILE.getId()) {
            fragment = new ProfileFragment();
        } else

        if (action == NavItem.MESSAGES.getId()) {
            fragment = new MessageFragment();
        } else

        if (action == NavItem.ALL_POSTS.getId()) {
            fragment = new PostFragment();
        } else

        if (action == NavItem.BOOK_EXCHANGE_POSTS.getId()) {
            fragment = new BookExchangeFragment();
        } else

        if (action == NavItem.CARPOOL_POSTS.getId()) {
            fragment = new CarpoolFragment();
        } else

        if (action == NavItem.GROUP_STUDY_POSTS.getId()) {
            fragment = new GroupStudyFragment();
        } else

        if (action == NavItem.FAVORITES.getId()) {
            fragment = new FavoriteFragment();
        } else

        if (action == Action.ACTION_POST_GENERAL.getId() ||
            action == Action.ACTION_POST_BOOK_EXCHANGE.getId() ||
            action == Action.ACTION_POST_GROUP_STUDY.getId()) {
            fragment = ActionPostFragment.newInstance(action);
        }

        Bundle args = new Bundle();
        args.putInt(ARG_ACTION_NUMBER, action);
        if (fragment != null) fragment.setArguments(args);

        return fragment;
    }

    // set current activity
    public static void setHubActivity(Activity activity) {
        mHubActivity = activity;
    }

    @Override
        public void onAttach(Context activity) {
            super.onAttach(activity);
            ((HubActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_ACTION_NUMBER));
        }
}