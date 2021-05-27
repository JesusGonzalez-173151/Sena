package luna.joel.sena.Adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.metas_views.view.*
import luna.joel.sena.Objetos.Meta
import luna.joel.sena.R

class MetasAdapter: BaseAdapter {
    var meta = ArrayList<Meta>()
    var context: Context? = null

    constructor(contexto: Context, meta: ArrayList<Meta>){
        this.context = contexto
        this.meta = meta
    }

    override fun getCount(): Int {
        return meta.size
    }

    override fun getItem(p0: Int): Any {
        return meta[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var metasP = meta[p0]
        var inflador = LayoutInflater.from(this.context)
        var vista = inflador.inflate(R.layout.metas_views, null)


        vista.metaNombre.setText(metasP.meta.get(p0))

        return vista
    }
}
