package com.madderate.skyloft.ItemDecorations;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class ThumbnailHorizontalItemDecoration extends RecyclerView.ItemDecoration {

    private float density;

    public ThumbnailHorizontalItemDecoration(float density) {
        this.density = density;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int itemPosition = parent.getChildAdapterPosition(view);

        if (itemPosition == 0) {
            outRect.set((int) (16 * density), 0, (int) (4 * density), 0);
        } else if (itemPosition == Objects.requireNonNull(parent.getAdapter()).getItemCount() - 1) {
            outRect.set((int) (4 * density), 0, (int) (16 * density), 0);
        } else {
            outRect.set((int) (4 * density), 0, (int) (4 * density), 0);
        }
    }
}
