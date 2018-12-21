package org.inframincer.flashlight

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager

/**
 * Created by ysera34 on 2018. 12. 21..
 */
class Torch(context: Context) {
    private var cameraId: String? = null
    private val cameraManager = context.getSystemService(Context.CAMERA_SERVICE)
            as CameraManager

    init {
        cameraId = getCameraId()
    }

    fun flashOn() {
        cameraManager.setTorchMode(cameraId, true)
    }

    fun flashOff() {
        cameraManager.setTorchMode(cameraId, false)
    }

    private fun getCameraId(): String? {
        val cameraIds = cameraManager.cameraIdList
        for (id in cameraIds) {
            val info = cameraManager.getCameraCharacteristics(id)
            val flashAvailable = info.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)
            val lensFacing = info.get(CameraCharacteristics.LENS_FACING)
            if (flashAvailable != null
                    && flashAvailable
                    && lensFacing != null
                    && lensFacing == CameraCharacteristics.LENS_FACING_BACK) {
                return id
            }
        }
        return null
    }
}