<g:render template="/template/header"/>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Tables</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item">
                <a href="${g.createLink(uri: '/dashboard')}">Dashboard</a></li>
            <li class="breadcrumb-item active">Kartu Rencana Studi</li>
        </ol>
        <g:if test="${flash.message}">
            <div class="alert alert-success text-center">${flash.message}</div>
        </g:if>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                List Students
                <a href="${g.createLink(uri: '/dashboard/add-course')}" class="btn btn-primary float-right" >Kunci KRS</a>
            </div>
            <div class="card-body">
                <table id="datatablesSimple">
                    <thead>
                    <tr>
                        <th>No.</th>
                        <th>Matakuliah</th>
                        <th>Kode</th>
                        <th>SKS</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% totalSKS = 0 %>
                    <g:each in="${studyPlans}" var="krs" status="i">
                        <tr>
                            <td>${i+1}</td>
                            <td>${krs.course.name}</td>
                            <td>${krs.course.code}</td>
                            <td>${krs.course.sks}</td>
                            <td>
                                <a href="${g.createLink(uri: '/dashboard/delete-study-plain/' + krs.id)}" class="badge badge-pill badge-danger">delete</a>
                            </td>
                        </tr>
                        <%
                            totalSKS += krs.course.sks
                        %>
                    </g:each>
                    </tbody>
                </table>
                <div class="overflow-auto">
                    <a class="font-weight-bolder text-decoration-none ml-2">Total SKS: ${totalSKS} SKS</a>
                    <a href="${g.createLink(uri: '/dashboard/add-course')}" class="btn btn-primary float-right ml-3">Belanja KRS</a>
                    <a href="${g.createLink(uri: '/dashboard/add-course')}" class="btn btn-primary float-end">Cetak KRS</a>
                </div>
            </div>
        </div>
    </div>
</main>
<g:render template="/template/footer"/>

