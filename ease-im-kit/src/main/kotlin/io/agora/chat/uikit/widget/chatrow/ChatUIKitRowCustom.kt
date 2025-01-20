package io.agora.chat.uikit.widget.chatrow

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import io.agora.chat.uikit.R
import io.agora.chat.uikit.common.ChatCustomMessageBody

class ChatUIKitRowCustom @JvmOverloads constructor(
    private val context: Context,
    private val attrs: AttributeSet? = null,
    private val defStyleAttr: Int = 0,
    isSender: Boolean = false
) : ChatUIKitRow(context, attrs, defStyleAttr, isSender) {
    private val contentView: TextView? by lazy { findViewById(R.id.tv_chatcontent) }

    override fun onInflateView() {
        inflater.inflate(
            if (!isSender) R.layout.uikit_row_received_message else R.layout.uikit_row_sent_message,
            this
        )
    }

    override fun onSetUpView() {
        (message?.body as? ChatCustomMessageBody)?.let {
            contentView?.text = context.getString(R.string.uikit_custom_message, it.event())
        }
    }

}