package luna.joel.sena

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.finansas_view.view.*

class FinanzasAdapter: BaseAdapter {

    var context: Context? =null
    var transacciones = ArrayList<Finanza>()

    constructor(context: Context, transacciones:ArrayList<Finanza>){
        this.context = context
        this.transacciones = transacciones
    }

    override fun getItem(p0: Int): Any {
        return transacciones[p0]
    }

    override fun getItemId(p0: Int): Long{
        return p0.toLong()
    }

    override fun getCount(): Int{
        return transacciones.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var transaccion = transacciones[p0]
        var inflator = LayoutInflater.from(this.context)
        var vista = inflator.inflate(R.layout.finansas_view,null)

        vista.title_ingreso.setText(transaccion.tipo)
        vista.cantida_ingreso.setText(transaccion.cantidad)
        vista.nota_ingreso.setText(transaccion.nota)


        return vista

    }




}