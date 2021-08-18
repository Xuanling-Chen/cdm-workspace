package cdm.event.workflow;

import cdm.event.workflow.meta.CustomisedWorkflowMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * In its initial iteration, this class is meant to support the DTCC TIW workflow information.
 * @version ${project.version}
 */
@RosettaClass

public interface CustomisedWorkflow extends RosettaModelObject {
	CustomisedWorkflow build();
	CustomisedWorkflow.CustomisedWorkflowBuilder toBuilder();
	
	/**
	 * In this initial iteration, this corresponds to the DTCC TIW element name.
	 */
	String getItemName();
	/**
	 * In this initial iteration, this corresponds to the DTCC value.
	 */
	String getItemValue();
	final static CustomisedWorkflowMeta metaData = new CustomisedWorkflowMeta();
	
	@Override
	default RosettaMetaData<? extends CustomisedWorkflow> metaData() {
		return metaData;
	} 
			
	static CustomisedWorkflow.CustomisedWorkflowBuilder builder() {
		return new CustomisedWorkflow.CustomisedWorkflowBuilderImpl();
	}
	
	default Class<? extends CustomisedWorkflow> getType() {
		return CustomisedWorkflow.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("itemName"), String.class, getItemName(), this);
		processor.processBasic(path.newSubPath("itemValue"), String.class, getItemValue(), this);
		
	}
	
	
	interface CustomisedWorkflowBuilder extends CustomisedWorkflow, RosettaModelObjectBuilder {
		CustomisedWorkflow.CustomisedWorkflowBuilder setItemName(String itemName);
		CustomisedWorkflow.CustomisedWorkflowBuilder setItemValue(String itemValue);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("itemName"), String.class, getItemName(), this);
			processor.processBasic(path.newSubPath("itemValue"), String.class, getItemValue(), this);
			
		}
		
	}
	
	//CustomisedWorkflow.CustomisedWorkflowImpl
	class CustomisedWorkflowImpl implements CustomisedWorkflow {
		private final String itemName;
		private final String itemValue;
		
		protected CustomisedWorkflowImpl(CustomisedWorkflow.CustomisedWorkflowBuilder builder) {
			this.itemName = builder.getItemName();
			this.itemValue = builder.getItemValue();
		}
		
		@Override
		public String getItemName() {
			return itemName;
		}
		
		@Override
		public String getItemValue() {
			return itemValue;
		}
		
		@Override
		public CustomisedWorkflow build() {
			return this;
		}
		
		@Override
		public CustomisedWorkflow.CustomisedWorkflowBuilder toBuilder() {
			CustomisedWorkflow.CustomisedWorkflowBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustomisedWorkflow.CustomisedWorkflowBuilder builder) {
			ofNullable(getItemName()).ifPresent(builder::setItemName);
			ofNullable(getItemValue()).ifPresent(builder::setItemValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustomisedWorkflow _that = getType().cast(o);
		
			if (!Objects.equals(itemName, _that.getItemName())) return false;
			if (!Objects.equals(itemValue, _that.getItemValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (itemName != null ? itemName.hashCode() : 0);
			_result = 31 * _result + (itemValue != null ? itemValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustomisedWorkflow {" +
				"itemName=" + this.itemName + ", " +
				"itemValue=" + this.itemValue +
			'}';
		}
	}
	
	//CustomisedWorkflow.CustomisedWorkflowBuilderImpl
	class CustomisedWorkflowBuilderImpl implements CustomisedWorkflow.CustomisedWorkflowBuilder {
	
		protected String itemName;
		protected String itemValue;
	
		public CustomisedWorkflowBuilderImpl() {
		}
	
		@Override
		public String getItemName() {
			return itemName;
		}
		
		@Override
		public String getItemValue() {
			return itemValue;
		}
		
	
		@Override
		public CustomisedWorkflow.CustomisedWorkflowBuilder setItemName(String itemName) {
			this.itemName = itemName==null?null:itemName;
			return this;
		}
		@Override
		public CustomisedWorkflow.CustomisedWorkflowBuilder setItemValue(String itemValue) {
			this.itemValue = itemValue==null?null:itemValue;
			return this;
		}
		
		@Override
		public CustomisedWorkflow build() {
			return new CustomisedWorkflow.CustomisedWorkflowImpl(this);
		}
		
		@Override
		public CustomisedWorkflow.CustomisedWorkflowBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustomisedWorkflow.CustomisedWorkflowBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getItemName()!=null) return true;
			if (getItemValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustomisedWorkflow.CustomisedWorkflowBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustomisedWorkflow.CustomisedWorkflowBuilder o = (CustomisedWorkflow.CustomisedWorkflowBuilder) other;
			
			
			merger.mergeBasic(getItemName(), o.getItemName(), this::setItemName);
			merger.mergeBasic(getItemValue(), o.getItemValue(), this::setItemValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustomisedWorkflow _that = getType().cast(o);
		
			if (!Objects.equals(itemName, _that.getItemName())) return false;
			if (!Objects.equals(itemValue, _that.getItemValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (itemName != null ? itemName.hashCode() : 0);
			_result = 31 * _result + (itemValue != null ? itemValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustomisedWorkflowBuilder {" +
				"itemName=" + this.itemName + ", " +
				"itemValue=" + this.itemValue +
			'}';
		}
	}
}
