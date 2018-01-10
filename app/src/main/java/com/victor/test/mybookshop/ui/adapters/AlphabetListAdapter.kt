package com.victor.test.mybookshop.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.victor.test.mybookshop.R
import com.victor.test.mybookshop.data.Letter
import com.victor.test.mybookshop.utils.inflate
import kotlinx.android.synthetic.main.adapter_alphabet_list.view.*

/**
 * Created by victorpalmacarrasco on 8/1/18.
 * ${APP_NAME}
 */
class AlphabetListAdapter(private var alphabetList: ArrayList<Letter>, private val letterClickListener: LetterClickListener):
        RecyclerView.Adapter<AlphabetListAdapter.LetterViewHolder>() {

    companion object {
        val TYPE_UNSELECTED = 0
        val TYPE_SELECTED = 1
    }


    override fun getItemViewType(position: Int): Int {

        return if (alphabetList[position].selected) {
            TYPE_SELECTED
        } else {
            TYPE_UNSELECTED
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        return if (viewType == TYPE_SELECTED) {
            LetterViewHolder(parent.inflate(R.layout.adapter_alphabet_list_selected))
        } else {
            LetterViewHolder(parent.inflate(R.layout.adapter_alphabet_list))
        }
    }


    override fun onBindViewHolder(holder: LetterViewHolder?, position: Int) {
        holder?.bind(alphabetList[position], letterClickListener)
    }

    override fun getItemCount(): Int = alphabetList.size

    fun setItemSelected(letter: Letter) {
        for (letter in alphabetList) {
            letter.selected = false
        }

        letter.selected = true
        notifyDataSetChanged()
    }


    class LetterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(letter: Letter, listener: LetterClickListener) = with(itemView) {

            txtLetter.text = letter.letter
            setOnClickListener { listener.onLetterClick(letter) }

        }
    }

    interface LetterClickListener {
        fun onLetterClick(letter: Letter)
    }
}