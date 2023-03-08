package siakad

class DashboardController {

    def index() {
        def data = [
                "name": "Darul Ikhsan",
                "uri" : "/dashboard"
        ]
        render(view: "/dashboard/index", model: data)
    }
}
