
import `in`.softcrunch.flikart.data.DataRepository
import `in`.softcrunch.flikart.data.DataSourceInterface
import `in`.softcrunch.flikart.data.local.AppDBHelper
import `in`.softcrunch.flikart.data.local.AppDatabase
import android.content.Context

object Injection {

    fun provideDataRepository(context: Context): DataSourceInterface {
        val database = AppDatabase.getInstance(context.applicationContext)
        return DataRepository.getInstance(context, AppDBHelper(database))
    }
}