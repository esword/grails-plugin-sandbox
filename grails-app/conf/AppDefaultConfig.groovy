import grails.util.GrailsUtil

// Override the table names used in GORM for the Comment domain class in the commentable plugin
grails.commentable.comment.table = "comments_table"
grails.commentable.commentlink.table = "comments_link_table"

library {
    init {
        createTestUsers = (GrailsUtil.environment == 'development')
    }
}