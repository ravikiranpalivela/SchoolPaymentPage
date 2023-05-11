package com.ravikiran.schoolpaymentpage.features.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ravikiran.schoolpaymentpage.R
import com.ravikiran.schoolpaymentpage.common.model.FeeMasterdata
import com.ravikiran.schoolpaymentpage.databinding.CartItemBinding

class CartAdapter : ListAdapter<FeeMasterdata, CartAdapter.ViewHolder>(
    DIFF_CALLBACK) {

    private var listener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.cart_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    fun setItemClickListener(listener: ItemClickListener) {
        this.listener = listener
    }

    interface ItemClickListener {
        fun onItemClick(item: FeeMasterdata)
    }

    inner class ViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FeeMasterdata) {
            binding.cartItem = item
            item.amountValue = item.totalFeeAmount?.toDouble()

            if(item.isRebate==1)
            {

            }

//            itemView.setOnClickListener {
//                listener?.onItemClick(item)
//            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FeeMasterdata>() {
            override fun areItemsTheSame(
                oldItem: FeeMasterdata,
                newItem: FeeMasterdata
            ): Boolean {
                return oldItem.feestructureId == newItem.feestructureId
            }

            override fun areContentsTheSame(
                oldItem: FeeMasterdata,
                newItem: FeeMasterdata
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}