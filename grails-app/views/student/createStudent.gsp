<g:render template="/template/header"/>
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Student</h1>
                <ol class="breadcrumb mb-4">
%{--                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>--}%
%{--                    <li class="breadcrumb-item active">Tables</li>--}%
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-user me-1"></i>
                        Input Student
                    </div>
                    <div class="card-body">
                        <g:form controller="student" action="saveStudent" method="POST">
                            <div class="form-group">
                                <label for="nim">NIM</label>
                                <input type="text" class="form-control" name="nim" id="nim" placeholder="nim">
%{--                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--}%
                            </div>
                            <div class="form-group">
                                <label for="name">Nama</label>
                                <input type="text" class="form-control" name="name" id="name" placeholder="Nama">
                            </div>
                            <div class="form-group">
                                <label for="major">Jurusan</label>
                                <input type="text" class="form-control" name="major" id="major" placeholder="Jurusan">
                            </div>
                            <div class="form-group">
                                <label for="year_of_entry">Angkatan</label>
                                <input type="text" class="form-control" name="year_of_entry" id="year_of_entry" placeholder="Angkatan">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="text" class="form-control" name="password" id="password" placeholder="Password">
                            </div>
                            <div class="form-group form-check">
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </g:form>
                    </div>
                </div>
            </div>
        </main>
<g:render template="/template/footer"/>

