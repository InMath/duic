package io.zhudy.duic.domain

import org.joda.time.DateTime
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * @author Kevin Zou (kevinz@weghst.com)
 */
@Document(collection = "app")
@CompoundIndexes(value = *[
CompoundIndex(name = "name_profile", unique = true, def = """{"name":1, "profile":1}"""),
CompoundIndex(name = "name_profile_content_text", def = """{"name":"text", "profile":"text", "content":"text"}""")
])
class App(
        @Id
        var id: String = "",
        @Field
        var name: String = "",
        @Field
        var profile: String = "",
        @Field
        var token: String = "",
        @Field("ip_limit")
        var ipLimit: String = "",
        @Field
        var description: String = "",
        @Field
        var v: Int = 1,
        @Indexed
        @Field("created_at")
        var createdAt: DateTime? = null,
        @Indexed
        @Field("updated_at")
        var updatedAt: DateTime? = null,
        @Field
        var content: String = "",
        @Indexed
        @Field
        var users: List<String> = emptyList()
)