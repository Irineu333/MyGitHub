package com.neu.mygithub.github.model

import com.google.gson.annotations.SerializedName

const val SEM_VALOR_INT: Int = -1
const val SEM_VALOR_STRING: String = ""
val SEM_VALOR = null

data class Repo(
    @SerializedName("id") var id: Int = SEM_VALOR_INT,
    @SerializedName("node_id") var node_id: String = SEM_VALOR_STRING,
    @SerializedName("name") var name: String = SEM_VALOR_STRING,
    @SerializedName("full_name") var full_name: String = SEM_VALOR_STRING,
    @SerializedName("owner") var owner: Owner? = SEM_VALOR /* objeto, informações proprietário */,
    @SerializedName("private") var private: Boolean? = SEM_VALOR,
    @SerializedName("html_url") var html_url: String = SEM_VALOR_STRING,
    @SerializedName("description") var description: String? = SEM_VALOR_STRING,
    @SerializedName("fork") var fork: Boolean? = SEM_VALOR,
    @SerializedName("url") var url: String = SEM_VALOR_STRING,
    @SerializedName("archive_url") var archive_url: String = SEM_VALOR_STRING,
    @SerializedName("assignees_url") var assignees_url: String = SEM_VALOR_STRING,
    @SerializedName("blobs_url") var blobs_url: String = SEM_VALOR_STRING,
    @SerializedName("branches_url") var branches_url: String = SEM_VALOR_STRING,
    @SerializedName("collaborators_url") var collaborators_url: String = SEM_VALOR_STRING,
    @SerializedName("comments_url") var comments_url: String = SEM_VALOR_STRING,
    @SerializedName("commits_url") var commits_url: String = SEM_VALOR_STRING,
    @SerializedName("compare_url") var compare_url: String = SEM_VALOR_STRING,
    @SerializedName("contents_url") var contents_url: String = SEM_VALOR_STRING,
    @SerializedName("contributors_url") var contributors_url: String = SEM_VALOR_STRING,
    @SerializedName("deployments_url") var deployments_url: String = SEM_VALOR_STRING,
    @SerializedName("downloads_url") var downloads_url: String = SEM_VALOR_STRING,
    @SerializedName("events_url") var events_url: String = SEM_VALOR_STRING,
    @SerializedName("forks_url") var forks_url: String = SEM_VALOR_STRING,
    @SerializedName("git_commits_url") var git_commits_url: String = SEM_VALOR_STRING,
    @SerializedName("git_refs_url") var git_refs_url: String = SEM_VALOR_STRING,
    @SerializedName("git_tags_url") var git_tags_url: String = SEM_VALOR_STRING,
    @SerializedName("git_url") var git_url: String = SEM_VALOR_STRING,
    @SerializedName("issue_comment_url") var issue_comment_url: String = SEM_VALOR_STRING,
    @SerializedName("issue_events_url") var issue_events_url: String = SEM_VALOR_STRING,
    @SerializedName("issues_url") var issues_url: String = SEM_VALOR_STRING,
    @SerializedName("keys_url") var keys_urls_url: String = SEM_VALOR_STRING,
    @SerializedName("labels_url") var labels_url: String = SEM_VALOR_STRING,
    @SerializedName("languages_url") var languages_url: String = SEM_VALOR_STRING,
    @SerializedName("merges_url") var merges_url: String = SEM_VALOR_STRING,
    @SerializedName("milestones_url") var milestones_url: String = SEM_VALOR_STRING,
    @SerializedName("notifications_url") var notifications_url: String = SEM_VALOR_STRING,
    @SerializedName("pulls_url") var pulls_url: String = SEM_VALOR_STRING,
    @SerializedName("releases_url") var releases_url: String = SEM_VALOR_STRING,
    @SerializedName("ssh_url") var ssh_url: String = SEM_VALOR_STRING,
    @SerializedName("stargazers_url") var stargazers_url: String = SEM_VALOR_STRING,
    @SerializedName("statuses_url") var statuses_url: String = SEM_VALOR_STRING,
    @SerializedName("subscribers_url") var subscribers_url: String = SEM_VALOR_STRING,
    @SerializedName("subscription_url") var subscription_url: String = SEM_VALOR_STRING,
    @SerializedName("tags_url") var tags_url: String = SEM_VALOR_STRING,
    @SerializedName("teams_url") var teams_url: String = SEM_VALOR_STRING,
    @SerializedName("trees_url") var trees_url: String = SEM_VALOR_STRING
) {

    data class Owner(
        @SerializedName("login") val login: String = SEM_VALOR_STRING,
        @SerializedName("id") val id: Int = SEM_VALOR_INT,
        @SerializedName("node_id") val node_id: String = SEM_VALOR_STRING,
        @SerializedName("avatar_url") val avatar_url: String = SEM_VALOR_STRING,
        @SerializedName("gravatar_id") val gravatar_id: String = SEM_VALOR_STRING,
        @SerializedName("url") val url: String = SEM_VALOR_STRING,
        @SerializedName("html_url") val html_url: String = SEM_VALOR_STRING,
        @SerializedName("followers_url") val followers_url: String = SEM_VALOR_STRING,
        @SerializedName("following_url") val following_url: String = SEM_VALOR_STRING,
        @SerializedName("gists_url") val gists_url: String = SEM_VALOR_STRING,
        @SerializedName("starred_url") val starred_url: String = SEM_VALOR_STRING,
        @SerializedName("subscriptions_url") val subscriptions_url: String = SEM_VALOR_STRING,
        @SerializedName("organizations_url") val organizations_url: String =SEM_VALOR_STRING,
        @SerializedName("repos_url") val repos_url: String = SEM_VALOR_STRING,
        @SerializedName("events_url") val events_url: String = SEM_VALOR_STRING,
        @SerializedName("received_events_url") val received_events_url: String = SEM_VALOR_STRING,
        @SerializedName("type") val type: String = SEM_VALOR_STRING,
        @SerializedName("site_admin") val site_admin: Boolean? = SEM_VALOR
    )
}