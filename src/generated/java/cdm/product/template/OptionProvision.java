package cdm.product.template;

import cdm.product.template.meta.OptionProvisionMeta;
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
 * A class for defining option provisions.
 * @version ${project.version}
 */
@RosettaClass

public interface OptionProvision extends RosettaModelObject {
	OptionProvision build();
	OptionProvision.OptionProvisionBuilder toBuilder();
	
	/**
	 * A provision that allows the specification of an embedded option within a swap giving the buyer of the option the right to terminate the swap, in whole or in part, on the early termination date.
	 */
	CancelableProvision getCancelableProvision();
	/**
	 * A provision that allows the specification of an embedded option with a swap giving the buyer of the option the right to extend the swap, in whole or in part, to the extended termination date.
	 */
	ExtendibleProvision getExtendibleProvision();
	final static OptionProvisionMeta metaData = new OptionProvisionMeta();
	
	@Override
	default RosettaMetaData<? extends OptionProvision> metaData() {
		return metaData;
	} 
			
	static OptionProvision.OptionProvisionBuilder builder() {
		return new OptionProvision.OptionProvisionBuilderImpl();
	}
	
	default Class<? extends OptionProvision> getType() {
		return OptionProvision.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("cancelableProvision"), processor, CancelableProvision.class, getCancelableProvision());
		processRosetta(path.newSubPath("extendibleProvision"), processor, ExtendibleProvision.class, getExtendibleProvision());
	}
	
	
	interface OptionProvisionBuilder extends OptionProvision, RosettaModelObjectBuilder {
		CancelableProvision.CancelableProvisionBuilder getOrCreateCancelableProvision();
		CancelableProvision.CancelableProvisionBuilder getCancelableProvision();
		ExtendibleProvision.ExtendibleProvisionBuilder getOrCreateExtendibleProvision();
		ExtendibleProvision.ExtendibleProvisionBuilder getExtendibleProvision();
		OptionProvision.OptionProvisionBuilder setCancelableProvision(CancelableProvision cancelableProvision);
		OptionProvision.OptionProvisionBuilder setExtendibleProvision(ExtendibleProvision extendibleProvision);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("cancelableProvision"), processor, CancelableProvision.CancelableProvisionBuilder.class, getCancelableProvision());
			processRosetta(path.newSubPath("extendibleProvision"), processor, ExtendibleProvision.ExtendibleProvisionBuilder.class, getExtendibleProvision());
		}
		
	}
	
	//OptionProvision.OptionProvisionImpl
	class OptionProvisionImpl implements OptionProvision {
		private final CancelableProvision cancelableProvision;
		private final ExtendibleProvision extendibleProvision;
		
		protected OptionProvisionImpl(OptionProvision.OptionProvisionBuilder builder) {
			this.cancelableProvision = ofNullable(builder.getCancelableProvision()).map(f->f.build()).orElse(null);
			this.extendibleProvision = ofNullable(builder.getExtendibleProvision()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CancelableProvision getCancelableProvision() {
			return cancelableProvision;
		}
		
		@Override
		public ExtendibleProvision getExtendibleProvision() {
			return extendibleProvision;
		}
		
		@Override
		public OptionProvision build() {
			return this;
		}
		
		@Override
		public OptionProvision.OptionProvisionBuilder toBuilder() {
			OptionProvision.OptionProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionProvision.OptionProvisionBuilder builder) {
			ofNullable(getCancelableProvision()).ifPresent(builder::setCancelableProvision);
			ofNullable(getExtendibleProvision()).ifPresent(builder::setExtendibleProvision);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionProvision _that = getType().cast(o);
		
			if (!Objects.equals(cancelableProvision, _that.getCancelableProvision())) return false;
			if (!Objects.equals(extendibleProvision, _that.getExtendibleProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cancelableProvision != null ? cancelableProvision.hashCode() : 0);
			_result = 31 * _result + (extendibleProvision != null ? extendibleProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionProvision {" +
				"cancelableProvision=" + this.cancelableProvision + ", " +
				"extendibleProvision=" + this.extendibleProvision +
			'}';
		}
	}
	
	//OptionProvision.OptionProvisionBuilderImpl
	class OptionProvisionBuilderImpl implements OptionProvision.OptionProvisionBuilder {
	
		protected CancelableProvision.CancelableProvisionBuilder cancelableProvision;
		protected ExtendibleProvision.ExtendibleProvisionBuilder extendibleProvision;
	
		public OptionProvisionBuilderImpl() {
		}
	
		@Override
		public CancelableProvision.CancelableProvisionBuilder getCancelableProvision() {
			return cancelableProvision;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder getOrCreateCancelableProvision() {
			CancelableProvision.CancelableProvisionBuilder result;
			if (cancelableProvision!=null) {
				result = cancelableProvision;
			}
			else {
				result = cancelableProvision = CancelableProvision.builder();
			}
			
			return result;
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder getExtendibleProvision() {
			return extendibleProvision;
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder getOrCreateExtendibleProvision() {
			ExtendibleProvision.ExtendibleProvisionBuilder result;
			if (extendibleProvision!=null) {
				result = extendibleProvision;
			}
			else {
				result = extendibleProvision = ExtendibleProvision.builder();
			}
			
			return result;
		}
		
	
		@Override
		public OptionProvision.OptionProvisionBuilder setCancelableProvision(CancelableProvision cancelableProvision) {
			this.cancelableProvision = cancelableProvision==null?null:cancelableProvision.toBuilder();
			return this;
		}
		@Override
		public OptionProvision.OptionProvisionBuilder setExtendibleProvision(ExtendibleProvision extendibleProvision) {
			this.extendibleProvision = extendibleProvision==null?null:extendibleProvision.toBuilder();
			return this;
		}
		
		@Override
		public OptionProvision build() {
			return new OptionProvision.OptionProvisionImpl(this);
		}
		
		@Override
		public OptionProvision.OptionProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionProvision.OptionProvisionBuilder prune() {
			if (cancelableProvision!=null && !cancelableProvision.prune().hasData()) cancelableProvision = null;
			if (extendibleProvision!=null && !extendibleProvision.prune().hasData()) extendibleProvision = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCancelableProvision()!=null && getCancelableProvision().hasData()) return true;
			if (getExtendibleProvision()!=null && getExtendibleProvision().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionProvision.OptionProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionProvision.OptionProvisionBuilder o = (OptionProvision.OptionProvisionBuilder) other;
			
			merger.mergeRosetta(getCancelableProvision(), o.getCancelableProvision(), this::setCancelableProvision);
			merger.mergeRosetta(getExtendibleProvision(), o.getExtendibleProvision(), this::setExtendibleProvision);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionProvision _that = getType().cast(o);
		
			if (!Objects.equals(cancelableProvision, _that.getCancelableProvision())) return false;
			if (!Objects.equals(extendibleProvision, _that.getExtendibleProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cancelableProvision != null ? cancelableProvision.hashCode() : 0);
			_result = 31 * _result + (extendibleProvision != null ? extendibleProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionProvisionBuilder {" +
				"cancelableProvision=" + this.cancelableProvision + ", " +
				"extendibleProvision=" + this.extendibleProvision +
			'}';
		}
	}
}
