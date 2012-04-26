package sapiens



import org.junit.*
import grails.test.mixin.*

@TestFor(DomaineCompetencesController)
@Mock(DomaineCompetences)
class DomaineCompetencesControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/domaineCompetences/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.domaineCompetencesInstanceList.size() == 0
        assert model.domaineCompetencesInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.domaineCompetencesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.domaineCompetencesInstance != null
        assert view == '/domaineCompetences/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/domaineCompetences/show/1'
        assert controller.flash.message != null
        assert DomaineCompetences.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/domaineCompetences/list'


        populateValidParams(params)
        def domaineCompetences = new DomaineCompetences(params)

        assert domaineCompetences.save() != null

        params.id = domaineCompetences.id

        def model = controller.show()

        assert model.domaineCompetencesInstance == domaineCompetences
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/domaineCompetences/list'


        populateValidParams(params)
        def domaineCompetences = new DomaineCompetences(params)

        assert domaineCompetences.save() != null

        params.id = domaineCompetences.id

        def model = controller.edit()

        assert model.domaineCompetencesInstance == domaineCompetences
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/domaineCompetences/list'

        response.reset()


        populateValidParams(params)
        def domaineCompetences = new DomaineCompetences(params)

        assert domaineCompetences.save() != null

        // test invalid parameters in update
        params.id = domaineCompetences.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/domaineCompetences/edit"
        assert model.domaineCompetencesInstance != null

        domaineCompetences.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/domaineCompetences/show/$domaineCompetences.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        domaineCompetences.clearErrors()

        populateValidParams(params)
        params.id = domaineCompetences.id
        params.version = -1
        controller.update()

        assert view == "/domaineCompetences/edit"
        assert model.domaineCompetencesInstance != null
        assert model.domaineCompetencesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/domaineCompetences/list'

        response.reset()

        populateValidParams(params)
        def domaineCompetences = new DomaineCompetences(params)

        assert domaineCompetences.save() != null
        assert DomaineCompetences.count() == 1

        params.id = domaineCompetences.id

        controller.delete()

        assert DomaineCompetences.count() == 0
        assert DomaineCompetences.get(domaineCompetences.id) == null
        assert response.redirectedUrl == '/domaineCompetences/list'
    }
}
