package ru.zhiev.withopenapi

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.zhiev.withopenapi.data.CountriesModel

class RvAdapter(private val dataSet: List<CountriesModel>) :
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.rv_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val name = dataSet[position].name.common
        val flagUrl = dataSet[position].flags.png

        Log.d("flagURL", flagUrl)
        Log.d("naming", name)
        viewHolder.textView.text = name
        Glide.with(viewHolder.imageView)
            .load(flagUrl)
            .into(viewHolder.imageView)
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            textView = view.findViewById(R.id.textView)
            imageView = view.findViewById(R.id.imageView)
        }
    }
}