package sapiens



import org.junit.*
import grails.test.mixin.*

@TestFor(CompetenceController)
@Mock(Competence)
class CompetenceControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/competence/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.competenceInstanceList.size() == 0
        assert model.competenceInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.competenceInstance != null
    }

    void testSave() {
        controller.save()

        assert model.competenceInstance != null
        assert view == '/competence/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/competence/show/1'
        assert controller.flash.message != null
        assert Competence.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/competence/list'


        populateValidParams(params)
        def competence = new Competence(params)

        assert competence.save() != null

        params.id = competence.id

        def model = controller.show()

        assert model.competenceInstance == competence
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/competence/list'


        populateValidParams(params)
        def competence = new Competence(params)

        assert competence.save() != null

        params.id = competence.id

        def model = controller.edit()

        assert model.competenceInstance == competence
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/competence/list'

        response.reset()


        populateValidParams(params)
        def competence = new Competence(params)

        assert competence.save() != null

        // test invalid parameters in update
        params.id = competence.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/competence/edit"
        assert model.competenceInstance != null

        competence.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/competence/show/$competence.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        competence.clearErrors()

        populateValidParams(params)
        params.id = competence.id
        params.version = -1
        controller.update()

        assert view == "/competence/edit"
        assert model.competenceInstance != null
        assert model.competenceInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/competence/list'

        response.reset()

        populateValidParams(params)
        def competence = new Competence(params)

        assert competence.save() != null
        assert Competence.count() == 1

        params.id = competence.id

        controller.delete()

        assert Competence.count() == 0
        assert Competence.get(competence.id) == null
        assert response.redirectedUrl == '/competence/list'
    }
}
