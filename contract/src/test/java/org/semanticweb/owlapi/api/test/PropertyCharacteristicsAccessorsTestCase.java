/* This file is part of the OWL API.
 * The contents of this file are subject to the LGPL License, Version 3.0.
 * Copyright 2014, The University of Manchester
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0 in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License. */
package org.semanticweb.owlapi.api.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.AsymmetricObjectProperty;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.DataProperty;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.FunctionalDataProperty;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.FunctionalObjectProperty;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.InverseFunctionalObjectProperty;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.IrreflexiveObjectProperty;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.ObjectProperty;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.ReflexiveObjectProperty;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.SymmetricObjectProperty;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.TransitiveObjectProperty;
import static org.semanticweb.owlapi.search.EntitySearcher.isAsymmetric;
import static org.semanticweb.owlapi.search.EntitySearcher.isFunctional;
import static org.semanticweb.owlapi.search.EntitySearcher.isInverseFunctional;
import static org.semanticweb.owlapi.search.EntitySearcher.isIrreflexive;
import static org.semanticweb.owlapi.search.EntitySearcher.isReflexive;
import static org.semanticweb.owlapi.search.EntitySearcher.isSymmetric;
import static org.semanticweb.owlapi.search.EntitySearcher.isTransitive;

import org.junit.Test;
import org.semanticweb.owlapi.api.test.baseclasses.TestBase;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Matthew Horridge, The University of Manchester, Bio-Health Informatics Group
 * @since 3.1.0
 */
@SuppressWarnings("javadoc")
public class PropertyCharacteristicsAccessorsTestCase extends TestBase {

    private static final String PROP2 = "prop";

    @Test
    public void testTransitive() {
        OWLOntology ont = getOWLOntology();
        OWLObjectProperty prop = ObjectProperty(iri(PROP2));
        assertFalse(isTransitive(prop, ont));
        OWLAxiom ax = TransitiveObjectProperty(prop);
        ont.add(ax);
        assertTrue(isTransitive(prop, ont));
    }

    @Test
    public void testSymmetric() {
        OWLOntology ont = getOWLOntology();
        OWLObjectProperty prop = ObjectProperty(iri(PROP2));
        assertFalse(isSymmetric(prop, ont));
        OWLAxiom ax = SymmetricObjectProperty(prop);
        ont.add(ax);
        assertTrue(isSymmetric(prop, ont));
    }

    @Test
    public void testAsymmetric() {
        OWLOntology ont = getOWLOntology();
        OWLObjectProperty prop = ObjectProperty(iri(PROP2));
        assertFalse(isAsymmetric(prop, ont));
        OWLAxiom ax = AsymmetricObjectProperty(prop);
        ont.add(ax);
        assertTrue(isAsymmetric(prop, ont));
    }

    @Test
    public void testReflexive() {
        OWLOntology ont = getOWLOntology();
        OWLObjectProperty prop = ObjectProperty(iri(PROP2));
        assertFalse(isReflexive(prop, ont));
        OWLAxiom ax = ReflexiveObjectProperty(prop);
        ont.add(ax);
        assertTrue(isReflexive(prop, ont));
    }

    @Test
    public void testIrreflexive() {
        OWLOntology ont = getOWLOntology();
        OWLObjectProperty prop = ObjectProperty(iri(PROP2));
        assertFalse(isIrreflexive(prop, ont));
        OWLAxiom ax = IrreflexiveObjectProperty(prop);
        ont.add(ax);
        assertTrue(isIrreflexive(prop, ont));
    }

    @Test
    public void testFunctional() {
        OWLOntology ont = getOWLOntology();
        OWLObjectProperty prop = ObjectProperty(iri(PROP2));
        assertFalse(isFunctional(prop, ont));
        OWLAxiom ax = FunctionalObjectProperty(prop);
        ont.add(ax);
        assertTrue(isFunctional(prop, ont));
    }

    @Test
    public void testInverseFunctional() {
        OWLOntology ont = getOWLOntology();
        OWLObjectProperty prop = ObjectProperty(iri(PROP2));
        assertFalse(isInverseFunctional(prop, ont));
        OWLAxiom ax = InverseFunctionalObjectProperty(prop);
        ont.add(ax);
        assertTrue(isInverseFunctional(prop, ont));
    }

    @Test
    public void testFunctionalDataProperty() {
        OWLOntology ont = getOWLOntology();
        OWLDataProperty prop = DataProperty(iri(PROP2));
        assertFalse(isFunctional(prop, ont));
        OWLAxiom ax = FunctionalDataProperty(prop);
        ont.add(ax);
        assertTrue(isFunctional(prop, ont));
    }
}
