package mbk.io.sabrina_hm2_5m

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import mbk.io.sabrina_hm2_5m.databinding.FragmentMainBinding
import mbk.io.sabrina_hm2_5m.LoveModel as LoveModel

class MainFragment : Fragment(), LoveView {

    private lateinit var binding: FragmentMainBinding
    var presenter = Presenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnGet.setOnClickListener {
               presenter.getData(etFname.text.toString(), etSname.text.toString())
            }
        }
    }

    override fun showResult(model: LoveModel) {
        val bundle = Bundle()
        bundle.putString("key1", model.firstName)
        bundle.putString("key2", model.secondName)
        bundle.putString("key3", model.percentage)
        bundle.putString("key4", model.result)
        findNavController().navigate(R.id.secondFragment, bundle)
    }

    override fun showError(error: String) {

    }
}


