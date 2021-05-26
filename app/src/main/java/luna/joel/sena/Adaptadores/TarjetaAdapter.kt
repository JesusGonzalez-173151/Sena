package luna.joel.sena.Adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.tarjeta_view.view.*
import luna.joel.sena.R
import luna.joel.sena.Objetos.Tarjeta

class TarjetaAdapter: BaseAdapter {

    var context: Context? =null
    var tarjetas = ArrayList<Tarjeta>()

    constructor(context: Context, tarjetas: ArrayList<Tarjeta>){
        this.context = context
        this.tarjetas = tarjetas
    }

    override fun getItem(p0: Int): Any {
        return tarjetas[p0]
    }

    override fun getItemId(p0: Int): Long{
        return p0.toLong()
    }

    override fun getCount(): Int{
        return tarjetas.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var tarjet = tarjetas[p0]
        var inflator = LayoutInflater.from(this.context)
        var vista = inflator.inflate(R.layout.tarjeta_view,null)

        vista.tipoTarjeta.setText(tarjet.tipo.get(p0))
        vista.fechaExpiracion.setText(tarjet.fecha.get(p0))
        vista.nombreTitular.setText(tarjet.nombre.get(p0))
        vista.numeroTarjetaVIEW.setText(tarjet.numero.get(p0))

        return vista

    }
}