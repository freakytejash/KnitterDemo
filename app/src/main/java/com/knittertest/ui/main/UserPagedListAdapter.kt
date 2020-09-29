package com.knittertest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.knittertest.databinding.RowUsersBinding
import com.knittertest.model.UserEntity
import com.knittertest.utils.Util

class UserPagedListAdapter : PagedListAdapter<UserEntity, UserPagedListAdapter.ViewHolder>(
    DIFF_CALLBACK
) {

    inner class ViewHolder(val binding: RowUsersBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(userEntity: UserEntity) {
            binding.tvId.text = userEntity.id.toString()
            binding.tvTitle.text = userEntity.title
            binding.tvBody.text = userEntity.body
            binding.tvCreated.text = Util.parseDateToddMMyyyy(userEntity.updated_at)

        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserEntity>() {
            override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity) =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity) =
                oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RowUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bindView(it) }
    }
}