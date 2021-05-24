package luna.joel.sena

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.finansas_view.view.*

class FinanzasAdapter: BaseAdapter {

    var context: Context? =null
    var finanzas = ArrayList<Finanza>()

    constructor(context: Context, finanzas:ArrayList<Finanza>){
        this.context = context
        this.finanzas = finanzas
    }

    override fun getItem(p0: Int): Any {
        return finanzas[p0]
    }

    override fun getItemId(p0: Int): Long{
        return p0.toLong()
    }

    override fun getCount(): Int{
        return finanzas.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var finanza = finanzas[p0]
        var inflator = LayoutInflater.from(this.context)
        var vista = inflator.inflate(R.layout.finansas_view,null)

        vista.title_ingreso.setText(finanza.tipo)
        vista.cantida_ingreso.setText(finanza.cantidad)
        vista.nota_ingreso.setText(finanza.nota)


        return vista

    }




}