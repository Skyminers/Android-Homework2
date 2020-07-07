package com.example.smalltiktok.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.smalltiktok.R
import java.util.*

class IconsAdapter(myDataset: List<IconsData>?) :
    RecyclerView.Adapter<IconsAdapter.MyViewHolder>() {
    private val mDataset: MutableList<IconsData>? = ArrayList<IconsData>()
    private var mItemClickListener: IOnItemClickListener? = null

    class MyViewHolder(private val contentView: View) : ViewHolder(contentView) {

        private val iconsTitle: TextView = contentView.findViewById(R.id.title)
        private val iconsUserImage: ImageView = contentView.findViewById(R.id.imageView)

        fun onBind(position: Int, data: IconsData) {
            iconsTitle.text = data.title
            iconsUserImage.setImageResource(data.imageID)
        }

        fun setOnClickListener(listener: View.OnClickListener?) {
            if (listener != null) {
                contentView.setOnClickListener(listener)
            }
        }

        fun setOnLongClickListener(listener: OnLongClickListener?) {
            if (listener != null) {
                contentView.setOnLongClickListener(listener)
            }
        }
    }

    fun setOnItemClickListener(listener: IOnItemClickListener?) {
        mItemClickListener = listener
    }

    fun addData(position: Int, data: IconsData) {
        mDataset!!.add(position, data)
        notifyItemInserted(position)
        if (position != mDataset.size) {
            //刷新改变位置item下方的所有Item的位置,避免索引错乱
            notifyItemRangeChanged(position, mDataset.size - position)
        }
    }

    fun removeData(position: Int) {
        if (null != mDataset && mDataset.size > position) {
            mDataset.removeAt(position)
            notifyItemRemoved(position)
            if (position != mDataset.size) {
                //刷新改变位置item下方的所有Item的位置,避免索引错乱
                notifyItemRangeChanged(position, mDataset.size - position)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.onBind(position, mDataset!![position])
        holder.setOnClickListener(View.OnClickListener {
            if (mItemClickListener != null) {
                mItemClickListener!!.onItemCLick(position, mDataset[position])
            }
        })
        holder.setOnLongClickListener(OnLongClickListener {
            if (mItemClickListener != null) {
                mItemClickListener!!.onItemLongCLick(position, mDataset[position])
            }
            false
        })
    }
    override fun getItemCount(): Int {
        return mDataset!!.size
    }

    interface IOnItemClickListener {
        fun onItemCLick(position: Int, data: IconsData?)
        fun onItemLongCLick(position: Int, data: IconsData?)
    }

    init {
        mDataset!!.addAll(myDataset!!)
    }
}
