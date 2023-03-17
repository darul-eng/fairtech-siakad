package siakad


class AuthMiddlewareInterceptor {
    AuthMiddlewareInterceptor() {
        matchAll()
                .excludes(controller: "auth")
    }

    boolean before() {
        if (session.user == null ) {
            redirect(controller: 'auth', action: 'index')
            return false
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
