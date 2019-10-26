# Scenario

- how to write bad code

- domain: retail app
- spec: add transactions on db operations
    => bad: Threadlocal, get or create
    => problem: not know when after transaction (executed code before transaction ends)
- spec: add properties on articles
    => create typed properties (Map[Id, Value])
    => bad: implicit functions from standard type to property value
    => bad: move implicit conversions to package object
    => bad: define "->" on Property def
    => bad: naming of Property for definition and id/value
    => bad: any parameter / non exhaustive match (ex: PropertyValue(a: Any): PropertyValue with correct implementation)
    => bad: apply that return an other type: Property.apply(name, value): (id, value)
- spec: use article in different context
    => too many Optional fields, default values and specific values

- mutable state?
- misleading type alias (`type ProcessResult = Unit`)
- function: return Try but throw anyway
