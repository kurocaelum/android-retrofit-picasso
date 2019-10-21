package android.imd.retrofitpicassoexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FotoAdapter(
    private val fotos: List<Foto>
): RecyclerView.Adapter<FotoAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return VH(v)
    }

    override fun getItemCount(): Int = fotos.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val foto = fotos.get(position)

        holder.textViewHead.text = foto.id
        holder.textViewDesc.text = foto.title

        Picasso.get()
            .load(foto.url)
            .into(holder.imageView)
    }


    class VH(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textViewHead: TextView = itemView.findViewById(R.id.txtHead)
        var textViewDesc: TextView = itemView.findViewById(R.id.txtDesc)
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}