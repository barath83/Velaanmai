package endgame.velanmai.androidgridlayout;

import android.support.annotation.NonNull;

public class BlogPostId {

    @com.google.firebase.database.Exclude
    public String BlogPostId;

    public <T extends BlogPostId> T withId(@NonNull final String id) {
        this.BlogPostId = id;
        return (T) this;
    }

}
