<g:render template="/template/header"/>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Tables</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item">
                <a href="${g.createLink(uri: '/dashboard')}">Dashboard</a></li>
            <li class="breadcrumb-item active">Student</li>
        </ol>
        <g:if test="${flash.message}">
            <div class="alert alert-success text-center">${flash.message}</div>
        </g:if>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                List Students
                <a href="${g.createLink(uri: '/dashboard/create-student')}" class="btn btn-primary float-right" >Add New Student</a>
            </div>
            <div class="card-body">
                <table id="datatablesSimple">
                    <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>NIM</th>
                        <th>Jurusan</th>
                        <th>Fakultas</th>
                        <th>Angkatan</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${students}" var="student" status="i">
                        <tr>
                            <td>${i+1}</td>
                            <td>${student.name}</td>
                            <td>${student.nim}</td>
                            <td>${student.major.name}</td>
                            <td>${student.major.faculty.name}</td>
                            <td>${student.yearOfEntry}</td>
                            <td>
                                <a href="${g.createLink(uri: '/dashboard/update-student/' + student.id)}" class="badge badge-pill badge-warning">update</a>
                                <a href="${g.createLink(uri: '/dashboard/delete-student/' + student.id)}" class="badge badge-pill badge-danger">delete</a>
                            </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>
<g:render template="/template/footer"/>

