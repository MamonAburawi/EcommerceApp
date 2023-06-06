@file:Suppress("DEPRECATION", "IMPLICIT_NOTHING_TYPE_ARGUMENT_IN_RETURN_POSITION","NonConstantResourceId")

package com.mamon.ecommerceapp.utils

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Parcelable
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.mamon.ecommerceapp.R
import com.mamon.ecommerceapp.data.Product

fun Fragment.showMessage(message: String){
    Snackbar.make(this.requireView(),message,Snackbar.LENGTH_SHORT).show()
}

fun View.show(){ visibility = View.VISIBLE}

fun View.hide(){ visibility = View.GONE}




fun Fragment.getDataFromBundle(key: String): Parcelable? {
    return try { arguments?.getParcelable(key) }
    catch (ex: Exception){ null }
}


fun Chip.resetStrokeWidth(){
    chipStrokeWidth = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        0F,
        context.resources.displayMetrics
    )
}


fun Chip.onSelectedChip(){
    isCheckedIconVisible = false // to hide the check icon
    chipStrokeColor = ColorStateList.valueOf(Color.WHITE)
    setStrokeWidth(4f) // set stroke width
}

fun Chip.onUnSelectedChip(){
    resetStrokeWidth()
}

fun Chip.initChip(color: String){
    chipBackgroundColor = ColorStateList.valueOf(Color.parseColor(color))
    isCheckable = true
}

fun Chip.setStrokeWidth(width: Float){
    chipStrokeWidth = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, width,
        context.resources.displayMetrics
    )
}


fun ViewPager2.slideNextImage(){
    val currentItem = currentItem
    if (currentItem < (adapter?.itemCount ?: (0 - 1))) {
        this.currentItem = currentItem + 1
    }
}

fun ViewPager2.slideToPreviousImage(){
    val currentItem = currentItem
    if (currentItem > 0) {
        this.currentItem = currentItem - 1
    }
}


fun View.setMargin(left: Int, top: Int, right: Int,bottom: Int){
    val param = layoutParams as ViewGroup.MarginLayoutParams
    param.setMargins( left, top, right, bottom)
    layoutParams = param
}



@EpoxyModelClass(layout = R.layout.item_space_model)
abstract class SpaceModel : EpoxyModelWithHolder<SpaceModel.Holder>() {

    @EpoxyAttribute
    var height: Int = 0

    override fun bind(holder: Holder) {
        holder.spaceView.layoutParams.height = height
    }

    inner class Holder : EpoxyHolder() {
        lateinit var spaceView: View

        override fun bindView(itemView: View) {
            spaceView = itemView.findViewById(R.id.view_space)
        }
    }
}



fun View.hideNavBottom(){
    val params = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.MATCH_PARENT
    )
    params.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM)

    layoutParams = params
}


fun View.showNavBottom(){
    val params = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.MATCH_PARENT
    )

    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
    layoutParams = params
}


fun Fragment.getProduct(): Product? {
    return try { arguments?.getParcelable(Constants.KEY_PRODUCT) } catch (ex: Exception){ Product() }
}

fun Fragment.getSelectedImage(): Int? {
    return try { arguments?.getInt(Constants.KEY_SELECTED_IMAGE) } catch (ex: Exception){ 0 }
}

fun Fragment.navigateHomeToDetails(product: Product){
    val data = bundleOf(Constants.KEY_PRODUCT to product)
    findNavController().navigate(R.id.action_home_to_details,data)
}

fun Fragment.navigateDetailsToPhotoViewer(image: Int){
    val data = bundleOf(Constants.KEY_SELECTED_IMAGE to image)
    findNavController().navigate(R.id.action_details_to_photoViewer,data)
}


fun Fragment.navigateSplashToHome(){
    findNavController().navigate(R.id.action_splash_to_home)
}




