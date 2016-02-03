import crudexample.g3.Role
import crudexample.g3.User
import crudexample.g3.UserRole

class BootStrap {

    def init = { servletContext ->
        Role adminRole = new Role('ADMIN').save()
        User testUser = new User('admin', 'admin').save()
        UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1
    }
    def destroy = {
    }
}
