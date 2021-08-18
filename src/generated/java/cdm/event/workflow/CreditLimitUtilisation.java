package cdm.event.workflow;

import cdm.event.workflow.meta.CreditLimitUtilisationMeta;
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
 * Credit limit utilisation breakdown by executed trades and pending orders.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditLimitUtilisation extends RosettaModelObject {
	CreditLimitUtilisation build();
	CreditLimitUtilisation.CreditLimitUtilisationBuilder toBuilder();
	
	/**
	 * Credit limit utilisation attributable to executed trades.
	 */
	CreditLimitUtilisationPosition getExecuted();
	/**
	 * Credit limit utilisation attributable to pending unexecuted orders.
	 */
	CreditLimitUtilisationPosition getPending();
	final static CreditLimitUtilisationMeta metaData = new CreditLimitUtilisationMeta();
	
	@Override
	default RosettaMetaData<? extends CreditLimitUtilisation> metaData() {
		return metaData;
	} 
			
	static CreditLimitUtilisation.CreditLimitUtilisationBuilder builder() {
		return new CreditLimitUtilisation.CreditLimitUtilisationBuilderImpl();
	}
	
	default Class<? extends CreditLimitUtilisation> getType() {
		return CreditLimitUtilisation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("executed"), processor, CreditLimitUtilisationPosition.class, getExecuted());
		processRosetta(path.newSubPath("pending"), processor, CreditLimitUtilisationPosition.class, getPending());
	}
	
	
	interface CreditLimitUtilisationBuilder extends CreditLimitUtilisation, RosettaModelObjectBuilder {
		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder getOrCreateExecuted();
		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder getExecuted();
		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder getOrCreatePending();
		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder getPending();
		CreditLimitUtilisation.CreditLimitUtilisationBuilder setExecuted(CreditLimitUtilisationPosition executed);
		CreditLimitUtilisation.CreditLimitUtilisationBuilder setPending(CreditLimitUtilisationPosition pending);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("executed"), processor, CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder.class, getExecuted());
			processRosetta(path.newSubPath("pending"), processor, CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder.class, getPending());
		}
		
	}
	
	//CreditLimitUtilisation.CreditLimitUtilisationImpl
	class CreditLimitUtilisationImpl implements CreditLimitUtilisation {
		private final CreditLimitUtilisationPosition executed;
		private final CreditLimitUtilisationPosition pending;
		
		protected CreditLimitUtilisationImpl(CreditLimitUtilisation.CreditLimitUtilisationBuilder builder) {
			this.executed = ofNullable(builder.getExecuted()).map(f->f.build()).orElse(null);
			this.pending = ofNullable(builder.getPending()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CreditLimitUtilisationPosition getExecuted() {
			return executed;
		}
		
		@Override
		public CreditLimitUtilisationPosition getPending() {
			return pending;
		}
		
		@Override
		public CreditLimitUtilisation build() {
			return this;
		}
		
		@Override
		public CreditLimitUtilisation.CreditLimitUtilisationBuilder toBuilder() {
			CreditLimitUtilisation.CreditLimitUtilisationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitUtilisation.CreditLimitUtilisationBuilder builder) {
			ofNullable(getExecuted()).ifPresent(builder::setExecuted);
			ofNullable(getPending()).ifPresent(builder::setPending);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilisation _that = getType().cast(o);
		
			if (!Objects.equals(executed, _that.getExecuted())) return false;
			if (!Objects.equals(pending, _that.getPending())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executed != null ? executed.hashCode() : 0);
			_result = 31 * _result + (pending != null ? pending.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilisation {" +
				"executed=" + this.executed + ", " +
				"pending=" + this.pending +
			'}';
		}
	}
	
	//CreditLimitUtilisation.CreditLimitUtilisationBuilderImpl
	class CreditLimitUtilisationBuilderImpl implements CreditLimitUtilisation.CreditLimitUtilisationBuilder {
	
		protected CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder executed;
		protected CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder pending;
	
		public CreditLimitUtilisationBuilderImpl() {
		}
	
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder getExecuted() {
			return executed;
		}
		
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder getOrCreateExecuted() {
			CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder result;
			if (executed!=null) {
				result = executed;
			}
			else {
				result = executed = CreditLimitUtilisationPosition.builder();
			}
			
			return result;
		}
		
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder getPending() {
			return pending;
		}
		
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder getOrCreatePending() {
			CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder result;
			if (pending!=null) {
				result = pending;
			}
			else {
				result = pending = CreditLimitUtilisationPosition.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CreditLimitUtilisation.CreditLimitUtilisationBuilder setExecuted(CreditLimitUtilisationPosition executed) {
			this.executed = executed==null?null:executed.toBuilder();
			return this;
		}
		@Override
		public CreditLimitUtilisation.CreditLimitUtilisationBuilder setPending(CreditLimitUtilisationPosition pending) {
			this.pending = pending==null?null:pending.toBuilder();
			return this;
		}
		
		@Override
		public CreditLimitUtilisation build() {
			return new CreditLimitUtilisation.CreditLimitUtilisationImpl(this);
		}
		
		@Override
		public CreditLimitUtilisation.CreditLimitUtilisationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilisation.CreditLimitUtilisationBuilder prune() {
			if (executed!=null && !executed.prune().hasData()) executed = null;
			if (pending!=null && !pending.prune().hasData()) pending = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExecuted()!=null && getExecuted().hasData()) return true;
			if (getPending()!=null && getPending().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilisation.CreditLimitUtilisationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitUtilisation.CreditLimitUtilisationBuilder o = (CreditLimitUtilisation.CreditLimitUtilisationBuilder) other;
			
			merger.mergeRosetta(getExecuted(), o.getExecuted(), this::setExecuted);
			merger.mergeRosetta(getPending(), o.getPending(), this::setPending);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilisation _that = getType().cast(o);
		
			if (!Objects.equals(executed, _that.getExecuted())) return false;
			if (!Objects.equals(pending, _that.getPending())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executed != null ? executed.hashCode() : 0);
			_result = 31 * _result + (pending != null ? pending.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilisationBuilder {" +
				"executed=" + this.executed + ", " +
				"pending=" + this.pending +
			'}';
		}
	}
}
