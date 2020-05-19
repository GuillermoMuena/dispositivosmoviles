package com.example.bookshelf.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.bookshelf.R
import com.example.bookshelf.classes.Book
import com.example.bookshelf.database.bookDao
import com.example.bookshelf.database.bookDatabase
import com.example.bookshelf.tabs.tab_basics
import com.example.bookshelf.tabs.tab_complex
import com.example.bookshelf.tabs.tab_review
import com.example.bookshelf.viewmodels.bookDetailsViewModel
import com.google.android.material.snackbar.Snackbar


class new_book_fragment_container : Fragment() {
    lateinit var v : View
    lateinit var tab_layout: TabLayout
    lateinit var viewPager: ViewPager2

    lateinit var book : Book

    private var datab: bookDatabase? = null
    private var book_dao: bookDao? = null
    private lateinit var viewModel : bookDetailsViewModel


    private val titles =
        arrayOf("Básicos", "Detallados", "Opinión")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_new_book_container_fragment, container, false)
        tab_layout = v.findViewById(R.id.tab_layout)
        viewPager = v.findViewById(R.id.view_pager)
        setHasOptionsMenu(true)
        return v
    }

     override fun onStart() {
         super.onStart()
         viewPager.adapter = createCardAdapter()
         TabLayoutMediator(tab_layout, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> tab.text = titles[0]
                    1 -> tab.text = titles[1]
                    2 -> tab.text = titles[2]
                    else -> tab.text = "undefined"
                }
            }).attach()


    }

    private fun createCardAdapter(): ViewPagerAdapter? {
        return ViewPagerAdapter(requireActivity())
    }

    class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun createFragment(position: Int): Fragment {

            return when(position){
                0 -> tab_basics()
                1 -> tab_complex()
                2 -> tab_review()

                else -> tab_basics()
            }
        }

        override fun getItemCount(): Int {
            return TAB_COUNT
        }

        companion object {
            private const val TAB_COUNT = 3
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.tabs_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        viewModel = ViewModelProvider(requireActivity()).get(bookDetailsViewModel::class.java)

        datab = bookDatabase.getAppDataBase(v.context)
        book_dao = datab?.bookDao()

        viewModel.books.observe(viewLifecycleOwner, Observer { result ->
            book = result
        })
        val id = when(item.itemId) {

            R.id.action_delete -> {
                book_dao!!.delete(book)
                val action = new_book_fragment_containerDirections.actionNewBookFragmentContainerToListFragment()
                v.findNavController().navigate(action)
            }

            R.id.action_edit -> {
                book_dao!!.delete(book)
                val action = new_book_fragment_containerDirections.actionNewBookFragmentContainerToEditBook()
                v.findNavController().navigate(action)
            }

            else -> ""
        }
        return super.onOptionsItemSelected(item)
    }
}
