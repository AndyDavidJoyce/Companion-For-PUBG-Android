package tech.zafrani.pubgapp.adapters.viewholders;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Item;

public class ConsumablesViewHolder extends ItemViewHolder{
    private final String IMAGE_URL_BASE= "https://github.com/Zsteven44/PUBG-Companion-Images/blob/master/images/";
    private final String ARG_RAW = "?raw=true";
    private final static String EMPTY_FIELD = " - ";
    private final TextView nameTextView;
    private final TextView typeTextView;
    private final TextView categoryTextView;
    private final TextView healTextView;
    private final TextView maxHealTextView;
    private final TextView boostTextView;
    private final TextView activateTimeTextView;
    private final TextView maxStackTextView;
    private final ImageView imageImageView;
    private final Context context;

    public ConsumablesViewHolder(@NonNull final View itemView, @NonNull final Context context) {
        super(itemView);
        this.context = context;
        this.nameTextView = (TextView) itemView.findViewById(R.id.row_item_name);
        this.typeTextView= (TextView) itemView.findViewById(R.id.row_item_type);
        this.categoryTextView = (TextView) itemView.findViewById(R.id.row_item_category);
        this.healTextView= (TextView) itemView.findViewById(R.id.row_item_heal);
        this.maxHealTextView= (TextView) itemView.findViewById(R.id.row_item_max_heal);
        this.boostTextView= (TextView) itemView.findViewById(R.id.row_item_boost);
        this.activateTimeTextView= (TextView) itemView.findViewById(R.id.row_item_activate_time);
        this.maxStackTextView= (TextView) itemView.findViewById(R.id.row_item_max_stack);
        this.imageImageView= (ImageView) itemView.findViewById(R.id.row_item_icon);


    }

    private void setItemName(@NonNull final String itemName) {
        this.nameTextView.setText(itemName);
    }

    private void setItemType(@NonNull final String itemType) {
        this.typeTextView.setText(itemType);
    }

    private void setItemCategory(@NonNull final String itemCategory) {
        this.categoryTextView.setText(itemCategory);
    }

    private void setItemHeal(@Nullable final Float itemHeal) {
        if (itemHeal!= null) {
            this.healTextView.setText(context.getString(R.string.row_item_heal, itemHeal));
        }else {
            this.healTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemMaxHeal(@Nullable final Float itemMaxHeal) {
        if (itemMaxHeal!= null) {
            this.maxHealTextView.setText(context.getString(R.string.row_item_max_heal, itemMaxHeal));
        }else {
            this.maxHealTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemBoost(@Nullable final Float itemBoost) {
        if (itemBoost!= null) {
            this.boostTextView.setText(context.getString(R.string.row_item_boost, itemBoost));
        }else {
            this.boostTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemActivateTime(@Nullable final Float itemActivateTime) {
        if (itemActivateTime!= null) {
            this.activateTimeTextView.setText(context.getString(R.string.row_item_activate_time, itemActivateTime));
        }else {
            this.activateTimeTextView.setText(EMPTY_FIELD);
        }
    }private void setItemMaxStack(@Nullable final Float itemMaxStack) {
        if (itemMaxStack != null) {
            this.maxStackTextView.setText(context.getString(R.string.row_item_max_stack, itemMaxStack));
        }else {
            this.maxStackTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemIcon(final String itemImage, String category) {
        if (itemImage != null) {
            Picasso.with(context).load(IMAGE_URL_BASE + category+ "/" + itemImage + ARG_RAW).into(imageImageView);
        }else {
            Picasso.with(context).load(R.mipmap.ic_launcher).into(imageImageView);

        }
    }

    @Override
    public void bind(Item item) {
        setItemName(item.getName());
        setItemType(item.getType());
        setItemCategory(item.getCategory());
        setItemHeal(item.getHeal());
        setItemMaxHeal(item.getMax_Heal());
        setItemBoost(item.getBoost());
        setItemActivateTime(item.getActivate_Time());
        setItemMaxStack(item.getMax_Stack());
        setItemCategory(item.getCategory());
        setItemIcon(item.getImageUrl(), item.getCategory());
    }
}





