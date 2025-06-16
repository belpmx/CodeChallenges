package airbnb;

import java.util.*;
import java.util.stream.Collectors;

public class DeepSearch {
    class ViolationPolicyType {
        public ViolationPolicyType(String violationPolicyTypeId, List<String> childViolationPolicyTypes) {
            this.violationPolicyTypeId = violationPolicyTypeId;
            this.childViolationPolicyTypes = childViolationPolicyTypes;
        }

        public String getViolationPolicyTypeId() {
            return violationPolicyTypeId;
        }

        public List<String> getChildViolationPolicyTypes() {
            return childViolationPolicyTypes;
        }

        private String violationPolicyTypeId;
        private List<String> childViolationPolicyTypes;
        // Constructor, getters, setters
    }


    public static class ViolationType {
        public String violationTypeId;
        public List<String> subTypeIds;

        public ViolationType(String violationTypeId, List<String> subTypeIds) {
            this.violationTypeId = violationTypeId;
            this.subTypeIds = subTypeIds;
        }


    }
    public static class Taxonomy {
        private final Map<String, ViolationType> idToViolationType = new HashMap<>();
        private final Map<String, List<String>> childToParentMap = new HashMap<>();

        public Taxonomy(List<ViolationType> violationTypes) {
            for (ViolationType violationType : violationTypes) {
                idToViolationType.put(violationType.violationTypeId, violationType);
                for (String childId : violationType.subTypeIds) {

                    childToParentMap
                            .computeIfAbsent(childId, k -> new ArrayList<>())
                            .add(violationType.violationTypeId);
                }
            }
        }

        public ViolationType getViolationType(String violationTypeId) {
            return idToViolationType.get(violationTypeId);
        }

        public List<ViolationType> getSubTypes(String violationTypeId) {
            ViolationType parent = idToViolationType.get(violationTypeId);
            if (parent == null || parent.subTypeIds.isEmpty()) {
                return Collections.emptyList();
            }
            return parent.subTypeIds.stream()
                    .map(idToViolationType::get)
                    .collect(Collectors.toList());
        }

        public List<ViolationType> getParentTypes(String violationTypeId) {

            List<String> parentIds = childToParentMap.getOrDefault(violationTypeId,
                    Collections.emptyList());
            return parentIds.stream()
                    .map(idToViolationType::get)
                    .collect(Collectors.toList());
        }
    }


}
