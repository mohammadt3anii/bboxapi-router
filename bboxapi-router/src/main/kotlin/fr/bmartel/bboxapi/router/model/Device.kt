package fr.bmartel.bboxapi.router.model

import com.google.gson.annotations.SerializedName
import fr.bmartel.bboxapi.router.BboxApiUtils

data class Device(
        val device: BboxDevice? = null
)

data class BboxDevice(
        val now: String? = null,
        val status: Int? = null,
        val numberofboots: Int? = null,
        val modelname: String? = null,
        @SerializedName("user_configured")
        val userConfigured: Int? = null,
        val display: Display? = null,
        val main: Version? = null,
        val reco: Version? = null,
        val running: Version? = null,
        val bcck: Version? = null,
        val ldr1: Version? = null,
        val ldr2: Version? = null,
        val firstusedate: String? = null,
        val uptime: Int? = null,
        val serialnumber: String? = null,
        val using: DeviceService? = null
)

data class Display(
        val luminosity: Int? = null,
        val state: String? = null
)

data class Version(
        private val version: String? = null,
        private val date: String? = null
) {
    fun getMajor(): Int {
        return BboxApiUtils.getVersionPattern(version, 1)
    }

    fun getMinor(): Int {
        return BboxApiUtils.getVersionPattern(version, 2)
    }

    fun getPatch(): Int {
        return BboxApiUtils.getVersionPattern(version, 3)
    }
}

data class DeviceService(
        val ipv4: Int? = null,
        val ipv6: Int? = null,
        val ftth: Int? = null,
        val adsl: Int? = null,
        val vdsl: Int? = null
)