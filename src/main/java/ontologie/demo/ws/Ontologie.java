package ontologie.demo.ws;

import org.apache.jena.ontology.*;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class Ontologie {

    //    @RequestMapping(value = "/ontologies",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public   List<JSONObject> getontologies() {
//        List<JSONObject> list=new ArrayList();
//        String fileName = "cake.owl";
//        try {
//            File file = new File(fileName);
//            FileReader reader = new FileReader(file);
//            OntModel model = ModelFactory
//                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
//            model.read(reader,null);
//            Iterator ontologiesIter = model.listOntologies();
//            while (ontologiesIter.hasNext()) {
//                Ontology ontology = (Ontology) ontologiesIter.next();
//
//                JSONObject obj = new JSONObject();
//                obj.put("name",ontology.getLocalName());
//                obj.put("uri",ontology.getURI());
//                list.add(obj);
//
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @RequestMapping(value = "/classesList",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public   List<JSONObject> getClasses() {
//        List<JSONObject> list=new ArrayList();
//        String fileName = "cake.owl";
//        try {
//            File file = new File(fileName);
//            FileReader reader = new FileReader(file);
//            OntModel model = ModelFactory
//                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
//            model.read(reader,null);
//            Iterator classIter = model.listClasses();
//            while (classIter.hasNext()) {
//                OntClass ontClass = (OntClass) classIter.next();
//                JSONObject obj = new JSONObject();
//                obj.put("name",ontClass.getLocalName());
//                obj.put("uri",ontClass.getURI());
//                list.add(obj);
//
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @RequestMapping(value = "/subClasses",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public   List<JSONObject> getSubClasses(@RequestParam("classname") String className) {
//        List<JSONObject> list=new ArrayList();
//        String fileName = "cake.owl";
//        try {
//            File file = new File(fileName);
//            FileReader reader = new FileReader(file);
//            OntModel model = ModelFactory
//                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
//            model.read(reader,null);
//            String classURI = "http://www.semanticweb.org/opendev/ontologies/2017/10/untitled-ontology-8#".concat(className);
//            System.out.println(classURI);
//            OntClass personne = model.getOntClass(classURI );
//            Iterator subIter = personne.listSubClasses();
//            while (subIter.hasNext()) {
//                OntClass sub = (OntClass) subIter.next();
//                    JSONObject obj = new JSONObject();
//                    obj.put("URI",sub.getURI());
//                    list.add(obj);
//
//
//            }
//
//            return list;
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @RequestMapping(value = "/Individus",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public   List<JSONObject> getIndividus() {
//        List<JSONObject> list=new ArrayList();
//        String fileName = "cake.owl";
//        try {
//            File file = new File(fileName);
//            FileReader reader = new FileReader(file);
//            OntModel model = ModelFactory
//                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
//            model.read(reader,null);
//            Iterator individus = model.listIndividuals();
//            while (individus.hasNext()) {
//                Individual   sub = (Individual) individus.next();
//                JSONObject obj = new JSONObject();
//                obj.put("name",sub.getLocalName());
//                obj.put("uri",sub.getURI());
//                list.add(obj);
//
//            }
//
//            return list;
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @RequestMapping(value = "/superClasses",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public   List<JSONObject> getSuperClasses(@RequestParam("classname") String className) {
//        List<JSONObject> list=new ArrayList();
//        String fileName = "cake.owl";
//        try {
//            File file = new File(fileName);
//            FileReader reader = new FileReader(file);
//            OntModel model = ModelFactory
//                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
//            model.read(reader,null);
//            String classURI = "http://www.semanticweb.org/opendev/ontologies/2017/10/untitled-ontology-8#".concat(className);
//            System.out.println(classURI);
//            OntClass personne = model.getOntClass(classURI );
//            Iterator subIter = personne.listSuperClasses();
//            while (subIter.hasNext()) {
//                OntClass sub = (OntClass) subIter.next();
//                JSONObject obj = new JSONObject();
//                obj.put("URI",sub.getURI());
//                list.add(obj);
//
//
//            }
//
//            return list;
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @RequestMapping(value = "/getClasProperty",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public   List<JSONObject> getClasProperty(@RequestParam("classname") String className) {
//        List<JSONObject> list=new ArrayList();
//        String fileName = "cake.owl";
//        try {
//            File file = new File(fileName);
//            FileReader reader = new FileReader(file);
//            OntModel model = ModelFactory
//                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
//            model.read(reader,null);
//            String classURI = "http://www.semanticweb.org/opendev/ontologies/2017/10/untitled-ontology-8#".concat(className);
//
//            OntClass ontClass = model.getOntClass(classURI );
//            Iterator subIter = ontClass.listDeclaredProperties();
//            while (subIter.hasNext()) {
//                OntProperty property = (OntProperty) subIter.next();
//                JSONObject obj = new JSONObject();
//                obj.put("propertyName",property.getLocalName());
//
//                    obj.put("propertyType",property.getRDFType().getLocalName());
//
//                if(property.getDomain()!=null)
//                    obj.put("domain", property.getDomain().getLocalName());
//                if(property.getRange()!=null)
//                    obj.put("range",property.getRange().getLocalName());
//
//                list.add(obj);
//
//
//            }
//
//            return list;
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @RequestMapping(value = "/equivClasses",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public   List<JSONObject> getequivClasses(@RequestParam("classname") String className) {
//        List<JSONObject> list=new ArrayList();
//        String fileName = "cake.owl";
//        try {
//            File file = new File(fileName);
//            FileReader reader = new FileReader(file);
//            OntModel model = ModelFactory
//                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
//            model.read(reader,null);
//            String classURI = "http://www.semanticweb.org/opendev/ontologies/2017/10/untitled-ontology-8#".concat(className);
//            System.out.println(classURI);
//            OntClass personne = model.getOntClass(classURI );
//            Iterator subIter = personne.listEquivalentClasses();
//            while (subIter.hasNext()) {
//                OntClass sub = (OntClass) subIter.next();
//                JSONObject obj = new JSONObject();
//                obj.put("URI",sub.getURI());
//                list.add(obj);
//
//
//            }
//
//            return list;
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @RequestMapping(value = "/Instances",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public   List<JSONObject> getInstancesClasses(@RequestParam("classname") String className) {
//        List<JSONObject> list=new ArrayList();
//        String fileName = "cake.owl";
//        try {
//            File file = new File(fileName);
//            FileReader reader = new FileReader(file);
//            OntModel model = ModelFactory
//                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
//            model.read(reader,null);
//            String classURI = "http://www.semanticweb.org/opendev/ontologies/2017/10/untitled-ontology-8#".concat(className);
//            System.out.println(classURI);
//            OntClass personne = model.getOntClass(classURI );
//            Iterator subIter = personne.listInstances();
//            while (subIter.hasNext()) {
//                Individual   sub = (Individual) subIter.next();
//                JSONObject obj = new JSONObject();
//                obj.put("name",sub.getLocalName());
//                obj.put("uri",sub.getURI());
//                list.add(obj);
//
//            }
//
//            return list;
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    @RequestMapping(value = "/isHierarchyRoot",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public   List<JSONObject> isHirarchieroot(@RequestParam("classname") String className) {
//        List<JSONObject> list=new ArrayList();
//        String fileName = "cake.owl";
//        try {
//            File file = new File(fileName);
//            FileReader reader = new FileReader(file);
//            OntModel model = ModelFactory
//                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
//            model.read(reader,null);
//            String classURI = "http://www.semanticweb.org/opendev/ontologies/2017/10/untitled-ontology-8#".concat(className);
//            System.out.println(classURI);
//            OntClass personne = model.getOntClass(classURI );
//
//          if (personne != null){
//              JSONObject obj = new JSONObject();
//              if (personne.isHierarchyRoot()){
//                  obj.put("isroot","true");
//              }else {
//                  obj.put("isroot","false");
//              }
//
//              list.add(obj);
//
//          }
//
//
//
//            return list;
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    @CrossOrigin
    @RequestMapping(value = "/getAllBases",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> query() {
        List<JSONObject> list=new ArrayList();
        String fileName = "cake.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String sprql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#>"+
                    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +

                    "SELECT DISTINCT ?bases" +
                    "                WHERE { ?subject cake:hasCakeBase ?bases}";
            Query query = QueryFactory.create(sprql);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get("bases").toString());
                obj.put("subject",solution.get("bases").toString().substring(40));
//                obj.put("property",solution.get("y").toString());
//                obj.put("object",solution.get("z").toString());
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @CrossOrigin
    @RequestMapping(value = "/getAllFrostings",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> query1() {
        List<JSONObject> list=new ArrayList();
        String fileName = "cake.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String sprql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#>"+
                    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +

                    "SELECT  DISTINCT ?frosting" +
                    "                 WHERE { ?subject cake:hasFrosting ?frosting}";
            Query query = QueryFactory.create(sprql);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get("frosting").toString());
                obj.put("subject",solution.get("frosting").toString().substring(40));
//                obj.put("property",solution.get("y").toString());
//                obj.put("object",solution.get("z").toString());
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @CrossOrigin
    @RequestMapping(value = "/getAllToppings",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> query2() {
        List<JSONObject> list=new ArrayList();
        String fileName = "cake.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String sprql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#>"+
                    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +

                    "SELECT DISTINCT ?toppings " +
                    "                WHERE { ?subject cake:hasTopping ?toppings}";
            Query query = QueryFactory.create(sprql);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get("toppings").toString());
                obj.put("subject",solution.get("toppings").toString().substring(40));
//                obj.put("property",solution.get("y").toString());
//                obj.put("object",solution.get("z").toString());
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @CrossOrigin
    @RequestMapping(value = "/getAllFruitAddings",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> query3() {
        List<JSONObject> list=new ArrayList();
        String fileName = "cake.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String sprql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#>"+
                    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +

                    "SELECT DISTINCT ?fruits " +
                    "WHERE { ?subject cake:hasFruit ?fruits}";
            Query query = QueryFactory.create(sprql);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get("fruits").toString());
                obj.put("subject",solution.get("fruits").toString().substring(40));
//                obj.put("property",solution.get("y").toString());
//                obj.put("object",solution.get("z").toString());
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @CrossOrigin
    @RequestMapping(value = "/getAllAdditonalIngredients",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> query4() {
        List<JSONObject> list=new ArrayList();
        String fileName = "cake.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null );

            String sprql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#>"+
                    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +

                    "SELECT DISTINCT ?additonal_ingredients " +
                    " WHERE { ?subject cake:hasIngredient ?additonal_ingredients}";
            Query query = QueryFactory.create(sprql);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get("additonal_ingredients").toString());
                obj.put("subject",solution.get("additonal_ingredients").toString().substring(40));
//                obj.put("property",solution.get("y").toString());
//                obj.put("object",solution.get("z").toString());
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @CrossOrigin
    @RequestMapping(value = "/getAllOccasions",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> query5() {
        List<JSONObject> list=new ArrayList();
        String fileName = "cake.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String sprql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#>"+
                    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +

                    "SELECT DISTINCT ?occasion " +
                    "WHERE { ?subject cake:hasOccasion ?occasion}";
            Query query = QueryFactory.create(sprql);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get("occasion").toString());
                obj.put("subject",solution.get("occasion").toString().substring(40));
//                obj.put("property",solution.get("y").toString());
//                obj.put("object",solution.get("z").toString());
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @CrossOrigin
    @RequestMapping(value = "/getAllShapes",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> query6() {
        List<JSONObject> list=new ArrayList();
        String fileName = "cake.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String sprql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#>"+
                    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +

                    "SELECT DISTINCT ?shape " +
                    "WHERE { ?subject cake:hasShape ?shape}";
            Query query = QueryFactory.create(sprql);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get("shape").toString());
                obj.put("subject",solution.get("shape").toString().substring(40));
//                obj.put("property",solution.get("y").toString());
//                obj.put("object",solution.get("z").toString());
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @CrossOrigin
    @RequestMapping(value = "/search",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> query7(String selectedBase,String selectedFrosting,String selectedTopping,String selectedFruitAdding,String selectedOtherIngredient,String selectedOccasion,String selectedShape) {
        List<JSONObject> list=new ArrayList();
        String fileName = "cake.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#>"+
                    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +

                    "SELECT ?subject ?price " +
                    "WHERE { ";

            if (!(selectedBase.equals("All Bases"))) {
                queryString += "?subject cake:hasCakeBase cake:" + selectedBase + ". ";

            }

            if (!(selectedFrosting.equals("All Frosting"))) {
                queryString += "?subject cake:hasFrosting cake:" + selectedFrosting + ". ";
            }
            if (!(selectedTopping.equals("All Toppings"))) {
                queryString += "?subject cake:hasTopping cake:" + selectedTopping + ". ";
            }

            if (!(selectedFruitAdding.equals("All FruitAdding"))) {
                queryString += "?subject cake:hasFruit cake:" + selectedFruitAdding + ". ";
            }

            if (!(selectedOtherIngredient.equals("All OtherIngredient"))) {
                queryString += "?subject cake:hasIngredient cake:" + selectedOtherIngredient + ". ";
            }

            if (!(selectedOccasion.equals("All Occasion"))) {
                queryString += "?subject cake:hasOccasion cake:" + selectedOccasion + ". ";
            }
            if (!(selectedShape.equals("All Shapes"))) {
                queryString += "?subject cake:hasShape cake:" + selectedShape + ".}";
            } else {
                queryString += "?subject cake:hasPriceValue ?price.}";
            }
            String c1 = queryString;
            Query query = QueryFactory.create(queryString);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get("subject").toString());
                obj.put("subject",solution.get("subject").toString().substring(40));
                obj.put("price",solution.get("price").toString().split("\\^")[0]);
//                obj.put("object",solution.get("z").toString());
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    @CrossOrigin
//    @RequestMapping(value = "/GetTypedQueryResults",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<JSONObject> query8(String sprql) {
//        List<JSONObject> list=new ArrayList();
//        String fileName = "cake.owl";
//        try {
//            File file = new File(fileName);
//            FileReader reader = new FileReader(file);
//            OntModel model = ModelFactory
//                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
//            model.read(reader,null);
//
//
//            Query query = QueryFactory.create(sprql);
//            QueryExecution qe = QueryExecutionFactory.create(query, model);
//            ResultSet resultSet = qe.execSelect();
//            int x=0;
//            while (resultSet.hasNext()) {
//                x++;
//                JSONObject obj = new JSONObject();
//                QuerySolution solution = resultSet.nextSolution();
//                System.out.println(solution.get("shape").toString());
//                obj.put("subject",solution.get("shape1").toString().substring(40));
////                obj.put("property",solution.get("y").toString());
////                obj.put("object",solution.get("z").toString());
//                list.add(obj);
//            }
//            System.out.println(x);
//            return list;
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
