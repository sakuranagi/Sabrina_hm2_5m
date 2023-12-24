package mbk.io.sabrina_hm2_5m

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import mbk.io.sabrina_hm2_5m.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private  lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            with(binding){
                tvResult1.text = arguments?.getString("key1").toString()
                tvResult2.text = arguments?.getString("key2").toString()
                tvResult3.text = arguments?.getString("key3").toString()
                tvResult4.text = arguments?.getString("key4").toString()
            }

        }
    }
}