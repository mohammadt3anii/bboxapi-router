package fr.bmartel.bboxapi.router.model

import com.google.gson.annotations.SerializedName

data class CallLog(
        val calllog: List<CallLogEntry>? = null
)

data class CallLogEntry(
        val id: Int? = null,
        val number: String? = null,
        val date: Long? = null,
        val type: CallType? = null,
        val answered: Int? = null,
        val duree: Int? = null
)

enum class CallType {
    @SerializedName("in")
    IN_CALL,
    @SerializedName("out")
    OUT_CALL
}