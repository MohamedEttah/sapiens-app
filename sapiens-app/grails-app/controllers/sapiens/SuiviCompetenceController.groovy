package sapiens

import org.springframework.dao.DataIntegrityViolationException

class SuiviCompetenceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [suiviCompetenceInstanceList: SuiviCompetence.list(params), suiviCompetenceInstanceTotal: SuiviCompetence.count()]
    }

    def create() {
        [suiviCompetenceInstance: new SuiviCompetence(params)]
    }

    def save() {
        def suiviCompetenceInstance = new SuiviCompetence(params)
        if (!suiviCompetenceInstance.save(flush: true)) {
            render(view: "create", model: [suiviCompetenceInstance: suiviCompetenceInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'suiviCompetence.label', default: 'SuiviCompetence'), suiviCompetenceInstance.id])
        redirect(action: "show", id: suiviCompetenceInstance.id)
    }

    def show() {
        def suiviCompetenceInstance = SuiviCompetence.get(params.id)
        if (!suiviCompetenceInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'suiviCompetence.label', default: 'SuiviCompetence'), params.id])
            redirect(action: "list")
            return
        }

        [suiviCompetenceInstance: suiviCompetenceInstance]
    }

    def edit() {
        def suiviCompetenceInstance = SuiviCompetence.get(params.id)
        if (!suiviCompetenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'suiviCompetence.label', default: 'SuiviCompetence'), params.id])
            redirect(action: "list")
            return
        }

        [suiviCompetenceInstance: suiviCompetenceInstance]
    }

    def update() {
        def suiviCompetenceInstance = SuiviCompetence.get(params.id)
        if (!suiviCompetenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'suiviCompetence.label', default: 'SuiviCompetence'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (suiviCompetenceInstance.version > version) {
                suiviCompetenceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'suiviCompetence.label', default: 'SuiviCompetence')] as Object[],
                          "Another user has updated this SuiviCompetence while you were editing")
                render(view: "edit", model: [suiviCompetenceInstance: suiviCompetenceInstance])
                return
            }
        }

        suiviCompetenceInstance.properties = params

        if (!suiviCompetenceInstance.save(flush: true)) {
            render(view: "edit", model: [suiviCompetenceInstance: suiviCompetenceInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'suiviCompetence.label', default: 'SuiviCompetence'), suiviCompetenceInstance.id])
        redirect(action: "show", id: suiviCompetenceInstance.id)
    }

    def delete() {
        def suiviCompetenceInstance = SuiviCompetence.get(params.id)
        if (!suiviCompetenceInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'suiviCompetence.label', default: 'SuiviCompetence'), params.id])
            redirect(action: "list")
            return
        }

        try {
            suiviCompetenceInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'suiviCompetence.label', default: 'SuiviCompetence'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'suiviCompetence.label', default: 'SuiviCompetence'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
