package hu.szte.mobilalk.maf_02;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<String>{

    private EditText mBookInput;
    private TextView mAuthorView;
    private TextView mTitleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        this.mBookInput = findViewById(R.id.bookInput);
        this.mAuthorView = findViewById(R.id.authorView);
        this.mTitleView = findViewById(R.id.titleView);

        if(savedInstanceState != null && !savedInstanceState.isEmpty()) {
            this.mAuthorView.setText(savedInstanceState.getCharSequence("authorView"));
            this.mTitleView.setText(String.valueOf("titleView"));
        }

        if(getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null,
                    this);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("authorView", this.mAuthorView.getText());
        outState.putCharSequence("titleView", this.mTitleView.getText());
    }

    public void searchBook(View view) {

    }

    public void backToMain(View view) {
        String reply = this.mTitleView.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(MessageActivity.EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
