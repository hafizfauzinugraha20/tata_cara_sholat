package id.hafiz.tatacarasholat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.GuideViewHolder> {

    private List<PrayerStep> steps;
    private Context context;

    public GuideAdapter(Context context, List<PrayerStep> steps) {
        this.context = context;
        this.steps = steps;
    }

    @NonNull
    @Override
    public GuideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prayer_step, parent, false);
        return new GuideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuideViewHolder holder, int position) {
        PrayerStep step = steps.get(position);

        // Set Text Header
        holder.tvNumber.setText(String.valueOf(position + 1));
        holder.tvTitle.setText(step.getTitle().replaceAll("^\\d+\\.\\s*", ""));
        holder.tvDescShort.setText(step.getDesc());

        // Expansion Logic
        boolean isExpanded = step.isExpanded();
        holder.layoutDetail.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.tvDescShort.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
        holder.ivArrow.setRotation(isExpanded ? 90 : 0);
        holder.tvNumber.setBackgroundResource(isExpanded ? R.drawable.bg_circle_emerald : R.drawable.bg_circle_emerald); // Sesuaikan jika ada drawable outline

        // Set Content Detail
        holder.tvArabic.setText(step.getArabic());
        holder.tvLatin.setText(step.getLatin());
        holder.tvMeaning.setText(step.getMeaning());

        // BERUBAH: Load Image dari Resource Lokal (R.drawable)
        // Pastikan gambar sudah ada di res/drawable, jika tidak gambar akan kosong atau error
        if (step.getImageResId() != 0) {
            holder.ivIllustration.setImageResource(step.getImageResId());
        } else {
            // Optional: Set gambar default jika ID = 0
            holder.ivIllustration.setBackgroundColor(context.getResources().getColor(R.color.gray_100));
        }

        // Handle List Niat
        holder.layoutNiatContainer.removeAllViews();
        if (step.getNiatList() != null && !step.getNiatList().isEmpty()) {
            for (PrayerStep.Niat niat : step.getNiatList()) {
                View niatView = LayoutInflater.from(context).inflate(R.layout.item_niat_simple, holder.layoutNiatContainer, false);
                TextView tvName = niatView.findViewById(R.id.tv_niat_name);
                TextView tvArab = niatView.findViewById(R.id.tv_niat_arabic);

                tvName.setText(niat.name);
                tvArab.setText(niat.arabic);

                holder.layoutNiatContainer.addView(niatView);
            }
            holder.layoutNiatContainer.setVisibility(View.VISIBLE);
        } else {
            holder.layoutNiatContainer.setVisibility(View.GONE);
        }

        // Click Listener Accordion
        holder.layoutHeader.setOnClickListener(v -> {
            step.setExpanded(!step.isExpanded());
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    static class GuideViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber, tvTitle, tvDescShort, tvArabic, tvLatin, tvMeaning;
        ImageView ivArrow, ivIllustration;
        LinearLayout layoutHeader, layoutDetail, layoutNiatContainer;

        public GuideViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tv_number);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescShort = itemView.findViewById(R.id.tv_desc_short);
            tvArabic = itemView.findViewById(R.id.tv_arabic);
            tvLatin = itemView.findViewById(R.id.tv_latin);
            tvMeaning = itemView.findViewById(R.id.tv_meaning);
            ivArrow = itemView.findViewById(R.id.iv_arrow);
            ivIllustration = itemView.findViewById(R.id.iv_illustration);
            layoutHeader = itemView.findViewById(R.id.layout_header);
            layoutDetail = itemView.findViewById(R.id.layout_detail);
            layoutNiatContainer = itemView.findViewById(R.id.layout_niat_container);
        }
    }
}