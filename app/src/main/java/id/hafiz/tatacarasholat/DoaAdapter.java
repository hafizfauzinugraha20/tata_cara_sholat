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

public class DoaAdapter extends RecyclerView.Adapter<DoaAdapter.DoaViewHolder> {

    private Context context;
    private List<Doa> doaList;

    public DoaAdapter(Context context, List<Doa> doaList) {
        this.context = context;
        this.doaList = doaList;
    }

    @NonNull
    @Override
    public DoaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_doa, parent, false);
        return new DoaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoaViewHolder holder, int position) {
        Doa item = doaList.get(position);

        holder.tvCategory.setText(item.getCategory().toUpperCase());
        holder.tvTitle.setText(item.getTitle());
        holder.tvArabic.setText(item.getArabic());
        holder.tvLatin.setText(item.getLatin());
        holder.tvMeaning.setText(item.getTranslation());

        // Logic Expand
        boolean isExpanded = item.isExpanded();
        holder.layoutDetail.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.ivArrow.setRotation(isExpanded ? 90 : 0);

        // Ubah warna icon jika expanded
        if (isExpanded) {
            holder.ivArrow.setColorFilter(context.getResources().getColor(R.color.emerald_700));
        } else {
            holder.ivArrow.setColorFilter(context.getResources().getColor(R.color.gray_500));
        }

        holder.layoutHeader.setOnClickListener(v -> {
            item.setExpanded(!item.isExpanded());
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return doaList.size();
    }

    static class DoaViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory, tvTitle, tvArabic, tvLatin, tvMeaning;
        ImageView ivArrow;
        LinearLayout layoutHeader, layoutDetail;

        public DoaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tv_category);
            tvTitle = itemView.findViewById(R.id.tv_title_doa);
            tvArabic = itemView.findViewById(R.id.tv_arabic_doa);
            tvLatin = itemView.findViewById(R.id.tv_latin_doa);
            tvMeaning = itemView.findViewById(R.id.tv_meaning_doa);
            ivArrow = itemView.findViewById(R.id.iv_arrow_doa);
            layoutHeader = itemView.findViewById(R.id.layout_header_doa);
            layoutDetail = itemView.findViewById(R.id.layout_detail_doa);
        }
    }
}